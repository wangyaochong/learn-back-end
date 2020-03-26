package com.wangyaochong.ioc;

import lombok.Data;

/**
 * @author wangyaochong
 * @date 2020/3/25 21:28
 */
@Data
public class WBeanDefinition {
    String beanClassName;
    boolean lazyInit = false;
    String factoryBeanName;
}
