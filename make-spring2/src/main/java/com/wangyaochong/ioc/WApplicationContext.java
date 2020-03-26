package com.wangyaochong.ioc;

import com.wangyaochong.anno.WAutowired;
import com.wangyaochong.anno.WController;
import com.wangyaochong.anno.WService;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangyaochong
 * @date 2020/3/25 21:41
 */
public class WApplicationContext extends WDefaultListableBeanFactory implements WBeanFactory {
    String[] configLocations;
    WBeanDefinitionReader reader;
    Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();
    Map<String, WBeanWrapper> factoryBeanInstanceCache = new ConcurrentHashMap<>();


    public WApplicationContext(String... configLocations) {
        this.configLocations = configLocations;
        try {
            refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void refresh() throws Exception {
        reader = new WBeanDefinitionReader(this.configLocations);
        List<WBeanDefinition> wBeanDefinitions = reader.loadBeanDefinition();
        doRegisterBeanDefinition(wBeanDefinitions);
        doAutowired();
    }

    private void doRegisterBeanDefinition(List<WBeanDefinition> beanDefinitions) {
        for (WBeanDefinition beanDefinition : beanDefinitions) {
            if (super.beanDefinitionMap.containsKey(beanDefinition.getFactoryBeanName())) {
                throw new RuntimeException("the " + beanDefinition.getFactoryBeanName() + " exists");
            }
            super.beanDefinitionMap.put(beanDefinition.getFactoryBeanName(), beanDefinition);
        }
    }

    private void doAutowired() {
        for (Map.Entry<String, WBeanDefinition> beanDefinitionEntry : super.beanDefinitionMap.entrySet()) {
            String beanName = beanDefinitionEntry.getKey();
            if (!beanDefinitionEntry.getValue().isLazyInit()) {
                try {
                    getBean(beanName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Object getBean(String beanName) throws Exception {
        WBeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        WBeanPostProcessor beanPostProcessor = new WBeanPostProcessor();
        Object instance = instantiateBean(beanDefinition);
        if (null == instance) {
            throw new RuntimeException("没有instance");
        }
        beanPostProcessor.postProcessBeforeInitialization(instance, beanName);

        WBeanWrapper beanWrapper = new WBeanWrapper();
        beanWrapper.setWrappedInstance(instance);
        beanWrapper.setWrapperClass(instance.getClass());

        this.factoryBeanInstanceCache.put(beanName, beanWrapper);

        beanPostProcessor.postProcessAfterInitialization(instance, beanName);
        populateBean(beanName, instance);
        return this.factoryBeanInstanceCache.get(beanName).getWrappedInstance();

    }

    private void populateBean(String beanName, Object instance) {
        Class<?> clazz = instance.getClass();
        if (clazz.isAnnotationPresent(WController.class) || clazz.isAnnotationPresent(WService.class)) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(WAutowired.class)) {
                    WAutowired autowired = field.getAnnotation(WAutowired.class);
                    String autowireBeanName = autowired.value().trim();
                    if ("".endsWith(autowireBeanName)) {
                        autowireBeanName = field.getType().getName();
                    }
                    field.setAccessible(true);
                    try {
                        field.set(instance, factoryBeanInstanceCache.get(autowireBeanName).getWrappedInstance());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private Object instantiateBean(WBeanDefinition beanDefinition) {
        Object instance = null;
        String className = beanDefinition.getBeanClassName();
        if (this.factoryBeanObjectCache.containsKey(className)) {
            instance = this.factoryBeanObjectCache.get(className);
        } else {
            try {
                Class<?> clazz = Class.forName(className);
                instance = clazz.newInstance();
                this.factoryBeanObjectCache.put(beanDefinition.getFactoryBeanName(), instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    @Override
    public Object getBean(Class<?> beanClass) throws Exception {
        return null;
    }

    public String[] getBeanDefinitionNames() {
        return this.beanDefinitionMap.keySet().toArray(new String[this.beanDefinitionMap.size()]);
    }

    public int getBeanDefinitionCount() {
        return this.beanDefinitionMap.size();
    }

    public Properties getConfig() {
        return reader.getConfig();
    }
}
