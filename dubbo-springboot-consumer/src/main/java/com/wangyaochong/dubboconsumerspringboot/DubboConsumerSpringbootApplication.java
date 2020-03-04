package com.wangyaochong.dubboconsumerspringboot;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableDubbo
@SpringBootApplication
@EnableHystrix
public class DubboConsumerSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerSpringbootApplication.class, args);
    }

}
