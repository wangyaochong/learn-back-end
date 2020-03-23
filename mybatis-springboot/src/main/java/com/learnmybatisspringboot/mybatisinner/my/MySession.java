package com.learnmybatisspringboot.mybatisinner.my;

import java.lang.reflect.Proxy;

public class MySession {
    public static Object queryMapper(Class clazz) {
        Object o = Proxy.newProxyInstance(MySession.class.getClassLoader(), new Class[]{clazz},new MyInvocationHandler());
        return o;
    }
}
