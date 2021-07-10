package com.example.rocketmqspringboot.controller;

import com.example.rocketmqspringboot.mq.RocketMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContorller {

    @Autowired RocketMqProducer rocketMqProducer;

    @GetMapping("/send")
    public String send() {
        rocketMqProducer.sendMsg("abc");
        return "ok";
    }
}
