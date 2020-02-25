package com.example.springinner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Car car(){
        System.out.println("config car");
        return new Car();
    }
    @Bean
    public House house(){
        car();
        System.out.println("config house");
        return new House();
    }
}
