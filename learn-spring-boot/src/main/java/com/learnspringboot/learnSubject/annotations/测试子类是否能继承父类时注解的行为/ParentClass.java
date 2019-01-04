package com.learnspringboot.learnSubject.annotations.测试子类是否能继承父类时注解的行为;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ParentClass {

    @PostConstruct
    public void init() {
        System.out.println("父类的init方法");
    }
}
