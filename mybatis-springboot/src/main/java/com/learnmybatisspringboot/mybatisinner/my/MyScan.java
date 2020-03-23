package com.learnmybatisspringboot.mybatisinner.my;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Import(MyImport.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyScan {
}
