package web;

import com.alibaba.fastjson.JSON;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import web.anno.MyRequestMapping;
import web.anno.MyResponseBody;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

//@WebServlet(value = "*.do", loadOnStartup = 1)
public class MyDispacherServlet extends HttpServlet {
    private static String basePath;
    private static String classPath = MyDispacherServlet.class.getResource("/").getPath();
    private static String scanPath;
    private Map<String, Method> map = new HashMap<>();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = request.getRequestURI();
            path = path.substring(path.lastIndexOf("/") + 1);
            Method method = map.get(path);
            if (method == null) {
                response.setStatus(404);
                return;
            }
            //在spring框架中是直接从beanFactory里面取出ControllerBean对象
            Class<?> declaringClass = method.getDeclaringClass();
            Object o = declaringClass.newInstance();
            Parameter[] methodParameters = method.getParameters();
            Object[] invokeParameter = new Object[method.getParameterCount()];
            for (int i = 0; i < methodParameters.length; i++) {
                Class<?> paramType = methodParameters[i].getType();
                if (paramType == HttpServletRequest.class) {
                    invokeParameter[i] = request;
                } else if (paramType == HttpServletResponse.class) {
                    invokeParameter[i] = response;
                } else if (paramType == String.class) {
                    String name = methodParameters[i].getName();
                    String parameter = request.getParameter(name);
                    invokeParameter[i] = parameter;
                } else {
                    Object paramObject = paramType.newInstance();
                    Field[] declaredFields = paramType.getDeclaredFields();
                    for (Field declaredField : declaredFields) {
                        declaredField.setAccessible(true);
                        String name = declaredField.getName();
                        Object parameter = request.getParameter(name);
                        declaredField.set(paramObject, parameter);
                    }
                    invokeParameter[i] = paramObject;
                }
            }
            Object invoke = method.invoke(o, invokeParameter);
            if (method.isAnnotationPresent(MyResponseBody.class)) {
                response.getWriter().write(JSON.toJSONString(invoke));
            } else {
                if (method.getReturnType() == String.class) {
//                    request.setCharacterEncoding("utf-8");
//                    response.setCharacterEncoding("utf-8");
                    request.getRequestDispatcher("/" + invoke).forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();

        try {
            String configPath = config.getInitParameter("mvcConfigPath");
            File configFile = new File(classPath + configPath);
            System.out.println("mvcConfigpath=" + configPath);
            SAXReader saxReader = new SAXReader();
            Document read = saxReader.read(configFile);
            Element rootElement = read.getRootElement();
            Element packageScan = rootElement.element("packageScan");
            Attribute aPackage = packageScan.attribute("package");
            scanPath = aPackage.getValue();
            File file = new File(classPath + scanPath);
            basePath = file.getPath();
            scanProject(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scanProject(File file) throws ClassNotFoundException {
        if (file.isDirectory()) {
            for (File one : file.listFiles()) {
                scanProject(one);
            }
        } else {
            String fileName = file.getName();
            if (fileName.substring(fileName.lastIndexOf(".")).equals(".class")) {
                String filePath = file.getPath();
                System.out.println(filePath);
                System.out.println(basePath);
                filePath = filePath.replace(basePath, "");
                filePath = scanPath + filePath;
                String classPath = filePath.replaceAll("\\\\", ".");
                String className = classPath.substring(0, classPath.lastIndexOf("."));
                Class<?> aClass = Class.forName(className);
                Method[] declaredMethods = aClass.getDeclaredMethods();
                for (Method method : declaredMethods) {
                    boolean annotationPresent = method.isAnnotationPresent(MyRequestMapping.class);
                    if (annotationPresent) {
                        MyRequestMapping annotation = method.getAnnotation(MyRequestMapping.class);
                        String value = annotation.value();
                        map.put(value, method);
                    }
                }
            }
        }
    }
}
