package com.wangyaochong.aop;

import java.lang.reflect.Method;

/**
 * @author wangyaochong
 * @date 2020/3/27 11:09
 */
public interface WJointPoint {
    Method getMethod();

    Object[] getArguments();

    Object getTarget();

    void setAttribute(String key, Object value);

    Object getAttribute(String key);
}
