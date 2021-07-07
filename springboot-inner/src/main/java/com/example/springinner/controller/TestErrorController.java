package com.example.springinner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestErrorController {

    @GetMapping("/testException")
    public String testErrorString(){
        throw new RuntimeException("测试exception");
    }

     @GetMapping("/testError")
    public String testErrorLong(){
         throw new Error("测试error");
//         return "ok";
    }

}
