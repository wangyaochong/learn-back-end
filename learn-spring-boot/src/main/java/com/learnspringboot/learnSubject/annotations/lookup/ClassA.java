package com.learnspringboot.learnSubject.annotations.lookup;

import lombok.Data;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
@Data
public class ClassA extends ClassBase {

    public ClassA() {
        super(System.currentTimeMillis());
    }

    @Override
    public void display() {
        System.out.println("classA generateTime=" + generateTime);
        getClassB().display();
    }

    @Lookup
    public ClassB getClassB() {
        /**
         * lookUp方法等同于
         * applicationContext.getBean(ClassB.class)
         */
        return null;
    }
}
