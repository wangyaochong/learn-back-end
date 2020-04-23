package com.wangyaochong.anno;

import java.lang.annotation.*;

/**
 * @author wangyaochong
 * @date 2020/3/25 21:22
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WRequestParam {
    String value() default "";
}