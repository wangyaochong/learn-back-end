package com.example.learnswagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/test")
public class TestController {

    public Integer test = 1;

    @GetMapping("/test")
    public String test() {

        int i = new Random().nextInt();
        int j = new Random().nextInt();
        int k = new Random().nextInt();
        System.out.println("sdfds");
        if (i == 1) {
            return "hello";
        }
        if (j == 1) {
            System.out.println("j==1");
        }

        return "test35     553  ";
    }
}
