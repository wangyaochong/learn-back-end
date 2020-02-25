package src.designPattern.dynamicRroxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TargetHandler implements InvocationHandler {
    private Object target;

    public TargetHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(target, args);
        return invoke;
    }
}
