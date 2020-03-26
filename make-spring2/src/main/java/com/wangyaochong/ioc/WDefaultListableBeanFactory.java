package com.wangyaochong.ioc;

import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangyaochong
 * @date 2020/3/25 21:40
 */
@Data
public class WDefaultListableBeanFactory extends WAbstractApplicationContext {
    Map<String, WBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

}
