package com.wangyaochong.aop.advice;

import com.wangyaochong.aop.WJointPoint;
import com.wangyaochong.aop.WMethodInterceptor;
import com.wangyaochong.aop.WMethodInvocation;

import java.lang.reflect.Method;

/**
 * @author wangyaochong
 * @date 2020/3/27 12:29
 */
public class WMethodBeforeAdvice extends WAbstractAspectAdvice implements WAdvice, WMethodInterceptor {
    WJointPoint jointPoint;

    public WMethodBeforeAdvice(Method aspectMethod, Object target) {
        super(aspectMethod, target);
    }

    public void before(Method method,Object[] args,Object target) throws Exception {
        invokeAdviceMethod(this.jointPoint, null, null);
    }

    public Object invoke(WMethodInvocation mi)throws Exception{
        this.jointPoint = mi;
        this.before(mi.getMethod(), mi.getArguments(), mi.getTarget());
        return mi.proceed();
    }
}
