package com.learnmybatisspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableTransactionManagement
@EnableWebMvc
@MapperScan(basePackages = "com.learnmybatisspringboot.generated.dao")
@EnableAspectJAutoProxy(exposeProxy = true)
public class MybatisSpringboot {

    public static void main(String[] args) {
        SpringApplication.run(MybatisSpringboot.class, args);
    }

}
