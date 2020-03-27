package com.wangyaochong.aop.advice;

import com.wangyaochong.aop.WJointPoint;
import com.wangyaochong.aop.WMethodInterceptor;
import com.wangyaochong.aop.WMethodInvocation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wangyaochong
 * @date 2020/3/27 12:33
 */
public class WAfterReturningAdvice extends WAbstractAspectAdvice implements WAdvice, WMethodInterceptor {
    WJointPoint jointPoint;

    public WAfterReturningAdvice(Method aspectMethod, Object target) {
        super(aspectMethod,target);
    }

    @Override
    public Object invoke(WMethodInvocation mi) throws Exception {
        Object retValue = mi.proceed();
        this.jointPoint=mi;
        afterReturning(retValue, mi.getMethod(), mi.getArguments(), mi.getTarget());
        return retValue;
    }

    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws InvocationTargetException, IllegalAccessException {
        invokeAdviceMethod(jointPoint, returnValue, null);
    }

}
