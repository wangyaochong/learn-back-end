package com.example.learnmybatisspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class LearnMybatisSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnMybatisSpringbootApplication.class, args);
    }

}
