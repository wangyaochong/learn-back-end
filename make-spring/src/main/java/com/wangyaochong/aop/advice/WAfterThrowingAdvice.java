package com.wangyaochong.aop.advice;

import com.wangyaochong.aop.WMethodInterceptor;
import com.wangyaochong.aop.WMethodInvocation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;

/**
 * @author wangyaochong
 * @date 2020/3/27 12:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WAfterThrowingAdvice extends WAbstractAspectAdvice implements WAdvice, WMethodInterceptor {

    WMethodInvocation mi;

    public WAfterThrowingAdvice(Method aspectMethod, Object target){
        super(aspectMethod,target);
    }

    @Override
    public Object invoke(WMethodInvocation mi) throws Exception {
        try {
            mi.proceed();
        }catch (Exception e){
            invokeAdviceMethod(mi, null, e.getCause());
            throw e;
        }
        return null;
    }
}
