package com.wangyaochong.springsecurityboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SpringSecurityBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityBootApplication.class, args);
    }

}
