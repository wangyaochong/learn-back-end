package com.wangyaochong.aop.advice;

import com.wangyaochong.aop.WAopConfig;
import lombok.Data;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangyaochong
 * @date 2020/3/27 11:13
 */
@Data
public class WAdviceSupport {
    Class targetClass;
    Object target;
    Pattern pointCutClassPattern;
    Map<Method, List<Object>> methodCache;
    WAopConfig config;

    public List<Object> getInterceptorsAndDynamicInterceptionAdvice(Method method, Class<?> targetClass) throws Exception {

        List<Object> cache = methodCache.get(method);
        if (cache == null) {
            Method m = targetClass.getMethod(method.getName(), method.getParameterTypes());
            cache = new ArrayList<>();
            cache.add(m);
            methodCache.put(method, cache);
        }
        return cache;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class targetClass) {
        this.targetClass = targetClass;
        parse();
    }

    public boolean pointCutMatch() {
        return pointCutClassPattern.matcher(this.targetClass.toString()).matches();
    }

    public static void main(String[] args) {
        String pointCut = "public .* com.wangyaochong.business.service..*..*(.*)";
        System.out.println("public java.lang.String com.wangyaochong.business.service.QueryServiceImpl.query(java.lang.String)".matches(pointCut));
    }

    private void parse() {
        String pointCut = config.getPointCut();
        String pointCutForClass = pointCut.substring(0, pointCut.lastIndexOf("(") - 3);
        pointCutClassPattern = Pattern.compile("class " + pointCutForClass.substring(pointCutForClass.lastIndexOf(" ") + 1));
        methodCache = new HashMap<>();
        Pattern pattern = Pattern.compile(pointCut);
        try {
            Class<?> aspectClass = Class.forName(config.getAspectClass());
            Map<String, Method> aspectMethods = new HashMap<>();
            for (Method method : aspectClass.getMethods()) {
                aspectMethods.put(method.getName(), method);
            }
            Class[] interfaces = targetClass.getInterfaces();
            for (Class anInterface : interfaces) {
                for (Method method : anInterface.getMethods()) {
                    cacheAdvice(method, pattern, aspectClass, aspectMethods);
                }
            }
            for (Method method : targetClass.getMethods()) {
                cacheAdvice(method, pattern, aspectClass, aspectMethods);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void cacheAdvice(Method method, Pattern pattern, Class<?> aspectClass, Map<String, Method> aspectMethods) {
        try {
            String methodString = method.toString();
            if (methodString.contains("throws")) {
                methodString = methodString.substring(0, methodString.lastIndexOf("throws")).trim();
            }
            Matcher matcher = pattern.matcher(methodString);
            if (matcher.matches()) {
                List<Object> advices = new ArrayList<>();
                if (config.getAspectBefore() != null) {
                    advices.add(new WMethodBeforeAdvice(aspectMethods.get(config.getAspectBefore()), aspectClass.newInstance()));
                }

                if (config.getAspectAfterThrow() != null) {
                    WAfterThrowingAdvice afterThrowingAdvice =
                            new WAfterThrowingAdvice(aspectMethods.get(config.getAspectAfterThrow()), aspectClass.newInstance());
                    advices.add(afterThrowingAdvice);
                }

                if (config.getAspectAfter() != null) {
                    advices.add(new WAfterReturningAdvice(aspectMethods.get(config.getAspectAfter()), aspectClass.newInstance()));
                }
                methodCache.put(method, advices);
                System.out.println("method=" + method + ",advices=" + advices);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
