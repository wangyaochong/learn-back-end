package com.wangyaochong.aop.proxy;

import com.wangyaochong.aop.advice.WAdviceSupport;
import com.wangyaochong.aop.WMethodInvocation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;

/**
 * @author wangyaochong
 * @date 2020/3/27 11:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WJdkAopProxy implements WAopProxy, InvocationHandler {
    WAdviceSupport config;

    @Override
    public Object getProxy() {
        return getProxy(config.getTargetClass().getClassLoader());
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return Proxy.newProxyInstance(classLoader, this.config.getTargetClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        List<Object> advice = config.getInterceptorsAndDynamicInterceptionAdvice(method, config.getTargetClass());
        return new WMethodInvocation(proxy, config.getTarget(), method, args, config.getTargetClass(), advice, new HashMap<>(), 0).proceed();
    }
}
