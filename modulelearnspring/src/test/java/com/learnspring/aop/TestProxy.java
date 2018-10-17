package com.learnspring.aop;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class TestProxy {
    @Test
    public void test(){
        Class<?> proxyClass = Proxy.getProxyClass(Base.class.getClassLoader());


    }
}
