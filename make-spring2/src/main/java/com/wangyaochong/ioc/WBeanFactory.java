package com.wangyaochong.ioc;

/**
 * @author wangyaochong
 * @date 2020/3/25 21:25
 */
public interface WBeanFactory {
    Object getBean(String beanName) throws Exception;

    Object getBean(Class<?> beanClass) throws Exception;
}
