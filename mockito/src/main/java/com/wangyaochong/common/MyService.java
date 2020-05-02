package com.wangyaochong.common;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author wangyaochong
 * date 2020/5/2 16:28
 */
public class MyService {
    public int method1(Integer paramInt, String paramStr, Collection collection, Serializable data) {
        throw new RuntimeException();
    }

    public void method2(Integer paramInt, String paramStr, Collection collection, Serializable data) {
        throw new RuntimeException();
    }
}
