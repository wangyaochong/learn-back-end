package com.example.springinner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestErrorController {

    @GetMapping("/testErrorString")
    public String testErrorString(){
        throw new RuntimeException("测试异常");
    }

     @GetMapping("/testErrorLong")
    public Long testErrorLong(){
        throw new RuntimeException("测试异常");
    }
}
