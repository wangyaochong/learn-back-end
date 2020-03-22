package com.example.learnmybatisspringboot.mybatisinner.my;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class MyInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("conn db");
        Select annotation = method.getAnnotation(Select.class);
        if(annotation!=null){
            String[] value = annotation.value();
            System.out.println(value[0]);
            //假设查询结果得到了
            return new ArrayList<>();
        }
        if(method.getName().equals("toString")){
            return proxy.getClass().getInterfaces()[0].getName();
        }
        return proxy;
    }
}
