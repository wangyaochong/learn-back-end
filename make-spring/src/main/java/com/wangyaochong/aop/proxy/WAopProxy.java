package com.wangyaochong.aop.proxy;

/**
 * @author wangyaochong
 * @date 2020/3/27 11:31
 */
public interface WAopProxy {
    Object getProxy();

    Object getProxy(ClassLoader classLoader);
}
