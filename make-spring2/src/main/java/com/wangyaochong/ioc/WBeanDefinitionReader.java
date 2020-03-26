package com.wangyaochong.ioc;

import com.wangyaochong.anno.WController;
import com.wangyaochong.anno.WService;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

/**
 * @author wangyaochong
 * @date 2020/3/25 21:42
 */
@Data
public class WBeanDefinitionReader {
    private List<String> registryBeanClassNameList = new ArrayList<>();
    private Properties config = new Properties();
    private final String SCAN_PACKAGE = "scanPackage";

    public WBeanDefinitionReader(String... location) {
        try (InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(location[0].replaceAll("classpath:", ""))) {
            config.load(resourceAsStream);
            doScanner(config.getProperty(SCAN_PACKAGE));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void doScanner(String scanPackage) {
        System.out.println("扫描中" + this.getClass().getResource("/"));
        URL url = this.getClass().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File classPath = new File(url.getFile());
        for (File file : Objects.requireNonNull(classPath.listFiles())) {
            if (file.isDirectory()) {
                doScanner(scanPackage + "." + file.getName());
            } else {
                if (file.getName().endsWith(".class")) {
                    String className = (scanPackage + "." + file.getName().replaceAll(".class", ""));
                    registryBeanClassNameList.add(className);
                }
            }
        }
    }

    public List<WBeanDefinition> loadBeanDefinition() {
        List<WBeanDefinition> result = new ArrayList<>();
        for (String className : registryBeanClassNameList) {
            try {
                Class<?> beanClass = Class.forName(className);
                if (beanClass.isInterface()) {
                    continue;
                }
//                如果有controller和service注解，就加载到ApplicationContext中
                if (beanClass.isAnnotationPresent(WController.class) ||
                        beanClass.isAnnotationPresent(WService.class)) {
                    result.add(doCreateBeanDefinition(toLowerFirstCase(beanClass.getSimpleName()), beanClass.getName()));
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    private WBeanDefinition doCreateBeanDefinition(String factoryBeanName, String beanClassName) {
        WBeanDefinition beanDefinition = new WBeanDefinition();
        beanDefinition.setBeanClassName(beanClassName);
        beanDefinition.setFactoryBeanName(factoryBeanName);
        return beanDefinition;
    }

    private String toLowerFirstCase(String name) {
        char[] chars = name.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }


}
