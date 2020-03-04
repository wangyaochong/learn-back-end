package com.wangyaochong.dubboproviderspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ImportResource;

//@EnableDubbo
@EnableHystrix
@ImportResource("classpath:provider.xml")
@SpringBootApplication
public class DubboProviderSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProviderSpringbootApplication.class, args);
    }

}
