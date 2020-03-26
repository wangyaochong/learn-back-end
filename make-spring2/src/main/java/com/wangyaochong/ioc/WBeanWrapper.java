package com.wangyaochong.ioc;

import lombok.Data;

/**
 * @author wangyaochong
 * @date 2020/3/25 21:38
 */
@Data
public class WBeanWrapper {
    private Object wrappedInstance;
    private Class<?> wrapperClass;
}
