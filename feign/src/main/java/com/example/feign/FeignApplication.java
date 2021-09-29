package com.example.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class FeignApplication {

    @PostMapping("/info")
    public FeignUser info(@RequestBody FeignUser user){
        System.out.println(user);
        return user;
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }

}
