package com.wangyaochong.aop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @author wangyaochong
 * @date 2020/3/27 11:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WMethodInvocation implements WJointPoint {

    Object proxy;
    Object target;
    Method method;
    Object[] arguments;
    Class<?> targetClass;
    List<Object> advices;
    Map<String, Object> attribute;
    int currentIndex;

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public Object getTarget() {
        return this.target;
    }

    @Override
    public void setAttribute(String key, Object value) {
        attribute.put(key, value);
    }

    @Override
    public Object getAttribute(String key) {
        return attribute;
    }

    public Object proceed() throws Exception {
        if (currentIndex == advices.size() - 1) {
            return this.method.invoke(this.target, this.arguments);
        }
        Object advice = advices.get(currentIndex);
        currentIndex++;
        if (advice instanceof WMethodInterceptor) {
            return ((WMethodInterceptor) advice).invoke(this);
        } else {
            return proceed();
        }
    }

}
