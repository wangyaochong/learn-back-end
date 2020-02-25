package src.designPattern.dynamicRroxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Target target = new TargetImpl();
        InvocationHandler handler = new TargetHandler(target);
        Target o = (Target) Proxy.newProxyInstance(Target.class.getClassLoader(), target.getClass().getInterfaces(), handler);
        o.handle();
    }
}
