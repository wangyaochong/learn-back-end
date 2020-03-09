package com.example.learnswagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/void")
public class VodController {
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
