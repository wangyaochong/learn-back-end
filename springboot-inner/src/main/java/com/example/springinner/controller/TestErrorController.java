package com.example.springinner.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class TestErrorController {

    @GetMapping("/testException")
    public String testErrorString() {
        throw new RuntimeException("测试exception");
    }

    @GetMapping("/testError")
    public String testErrorLong() {
        throw new Error("测试error");
//         return "ok";
    }

    @GetMapping("/getIp")
    public String getIp(HttpServletRequest request) {
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getRemoteHost());
        System.out.println(request.getRemotePort());
        return "ok";
    }

    @Scheduled(fixedDelay = 5000)
    public void task() {
        log.info("hello fixedDelay");
    }
}
