package com.example.springinner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@EnableWebMvc   //启用web功能
public class SpringInnerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringInnerApplication.class, args);
    }
}
