package com.learnspring.startProcess;

import com.learnspring.aop.Base;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationContextAware implements ApplicationContextAware{
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Base bean = applicationContext.getBean(Base.class);
    }
}
