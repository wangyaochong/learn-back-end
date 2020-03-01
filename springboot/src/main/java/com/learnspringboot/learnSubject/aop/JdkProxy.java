package com.learnspringboot.learnSubject.aop;


import com.learnspringboot.learnSubject.aop.interfaces.IBase;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {
    Object object;

    public JdkProxy(Object target) {
        this.object = target;
    }

    public JdkProxy() {
    }

    public Object bind(Object target) {
        this.object = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("MyInvocationHandler invoke begin");
        Class<?> aClass = proxy.getClass();
        System.out.println(aClass);
        System.out.println("proxy: " + aClass.getName());
        System.out.println("method: " + method.getName());
        if (args != null) {
            for (Object o : args) {
                System.out.println("arg: " + o);
            }
        }


        //通过反射调用 被代理类的方法
        Object invokeResult = method.invoke(object, args);
        System.out.println("MyInvocationHandler invoke end");
        return invokeResult;
    }

    public static void main(String[] args) {
        Base base = new Base();
        IBase o = (IBase) new JdkProxy().bind(base);
        String s = o.methodAop("asd");
        System.out.println(o);
    }

}
