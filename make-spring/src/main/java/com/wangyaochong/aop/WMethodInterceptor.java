package com.wangyaochong.aop;

/**
 * @author wangyaochong
 * @date 2020/3/27 11:11
 */
public interface WMethodInterceptor {
    Object invoke(WMethodInvocation mi) throws Exception;
}
