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
    //    对象map
    private Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();
    //    创建中的对象的BeanWrapper的map，在对象实例化后可以删除
    private Map<String, WBeanWrapper> factoryBeanInstanceCache = new ConcurrentHashMap<>();


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
            throw new RuntimeException("无法实例化,beanName=" + beanName);
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
                    try {
                        WAutowired autowired = field.getAnnotation(WAutowired.class);
                        String autowireBeanName = autowired.value().trim();
                        field.setAccessible(true);
                        if ("".equals(autowireBeanName)) {
                            field.set(instance, getBean(field.getType()));
                        } else {
                            field.set(instance, getBean(beanName));
                        }
                    } catch (Exception e) {
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
        for (Map.Entry<String, Object> entry : factoryBeanObjectCache.entrySet()) {
            //这里直接返回按照类型匹配的第一个对象了
            if (beanClass.isAssignableFrom(entry.getValue().getClass())) {
                return entry.getValue();
            }
        }
        //如果没有，就需要实例化对象了
        for (Map.Entry<String, WBeanDefinition> entry : beanDefinitionMap.entrySet()) {
            WBeanDefinition value = entry.getValue();
            String beanClassName = value.getBeanClassName();
            if (beanClass.isAssignableFrom(Class.forName(beanClassName))) {
                return getBean(entry.getKey());//如果有符合的对象，就新建一个
            }
        }
        //如果还没有，就要抛出异常了
        throw new RuntimeException("找不到对象，beanClass=" + beanClass);
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
