package com.example.springinner.component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyComponent {
    public MyComponent(){
        System.out.println("MyComponent construct");
    }
    @PostConstruct
    public void init(){
        System.out.println("MyComponent init");
    }
}
