package com.learnspringboot.learnSubject.startProcess;

import com.learnspringboot.learnSubject.startProcess.factoryBean.MyBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * FactoryBean主要用于简化复杂Bean的创建步骤
 */
@Service
public class MyFactoryBean implements FactoryBean<MyBean>, ApplicationContextAware {
    @Override
    public MyBean getObject() throws Exception {
        return new MyBean(new Random(System.currentTimeMillis()).nextInt());
    }

    @Override
    public Class<?> getObjectType() {
        return MyBean.class;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("--------------通过factoryBean构造了 MyBean---------------");
        //两次id是不一样的，因为调用了两次FactoryBean#getObject，对于单例也是如此，显示调用2次，不是同一个对象，但是如果是在spring框架中，则对于单例会被缓存起来的
        MyBean bean = applicationContext.getBean("myFactoryBean", MyBean.class);
        System.out.println("bean1 id =" + bean.getId());
        MyBean bean2 = applicationContext.getBean("myFactoryBean", MyBean.class);
        System.out.println("bean2 id =" + bean2.getId());
    }
}
