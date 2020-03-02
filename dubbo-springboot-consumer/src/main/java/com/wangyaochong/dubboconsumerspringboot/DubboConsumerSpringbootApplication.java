package com.wangyaochong.dubboconsumerspringboot;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class DubboConsumerSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerSpringbootApplication.class, args);
    }

}
