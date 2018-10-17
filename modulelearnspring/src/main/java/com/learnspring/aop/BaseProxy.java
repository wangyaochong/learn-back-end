package com.learnspring.aop;


import com.learnspring.aop.interfaces.IBase;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BaseProxy implements InvocationHandler {
    Object object;
    public BaseProxy(Object target){
        this.object=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("MyInvocationHandler invoke begin");
        Class<?> aClass = proxy.getClass();
        System.out.println(aClass);
        System.out.println("proxy: "+ aClass.getName());
        System.out.println("method: "+ method.getName());
        if(args!=null){
            for(Object o : args){
                System.out.println("arg: "+ o);
            }
        }


        //通过反射调用 被代理类的方法
        Object invokeResult = method.invoke(object, args);
        System.out.println("MyInvocationHandler invoke end");
        return invokeResult;
    }

    public static void main(String[] args) {
        Base base = new Base();
        BaseProxy baseProxy=new BaseProxy(base);
        Class<?>[] interfaces = base.getClass().getInterfaces();
        System.out.println(interfaces);
        IBase o = (IBase) Proxy.newProxyInstance(base.getClass().getClassLoader(), interfaces, baseProxy);
        String s = o.methodAop("asd");
        System.out.println(o);
    }

}
