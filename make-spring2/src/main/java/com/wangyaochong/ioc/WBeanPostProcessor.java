package com.wangyaochong.ioc;

/**
 * @author wangyaochong
 * @date 2020/3/25 22:14
 */
public class WBeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}
