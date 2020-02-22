package com.example.springinner.circleDepend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class B {
    @Autowired
    A a;

    @PostConstruct
    public void init() {
        System.out.println("-----------B init---------");
    }
}

