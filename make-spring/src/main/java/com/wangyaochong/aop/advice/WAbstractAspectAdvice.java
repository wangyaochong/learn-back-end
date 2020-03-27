package com.wangyaochong.aop.advice;

import com.wangyaochong.aop.WJointPoint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wangyaochong
 * @date 2020/3/27 11:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class WAbstractAspectAdvice implements WAdvice {
    Method aspectMethod;
    Object aspectTarget;

    Object invokeAdviceMethod(WJointPoint jointPoint, Object returnValue, Throwable ex) throws InvocationTargetException, IllegalAccessException {
        Class<?>[] parameterTypes = aspectMethod.getParameterTypes();
        if (parameterTypes.length == 0) {
            return this.aspectMethod.invoke(aspectTarget);
        } else {
            Object[] args = new Object[parameterTypes.length];
            for (int i = 0 ; i < parameterTypes.length ; i++) {
                if (parameterTypes[i] == WJointPoint.class) {
                    args[i] = jointPoint;
                } else if (parameterTypes[i] == Throwable.class) {
                    args[i] = ex;
                } else if (parameterTypes[i] == Object.class) {
                    args[i] = returnValue;
                }
            }
            return aspectMethod.invoke(aspectTarget, args);
        }
    }

}
