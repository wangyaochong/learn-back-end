package src.myaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyAopClassInvocationHandler implements InvocationHandler {
    public Object object = null;

    public MyAopClassInvocationHandler(Object object) {
        this.object = object;
    }

//    public Object bind(Object target) {
//        this.object = target;
//        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
//                target.getClass().getInterfaces(), this);
//    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("MyAopClassInvocationHandler");
        return method.invoke(this.object, args);
    }
}
