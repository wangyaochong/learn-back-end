package com.example.learnmybatisspringboot.my;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("conn db");
        Select annotation = method.getAnnotation(Select.class);
        if(annotation!=null){
            String[] value = annotation.value();
            System.out.println(value[0]);
        }
        if(method.getName().equals("toString")){
            return proxy.getClass().getInterfaces()[0].getName();
        }
        return proxy;
    }
}
