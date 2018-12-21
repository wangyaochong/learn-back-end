package com.example.cloudstream.personChannel.controller;

import com.example.cloudstream.personChannel.bean.Person;
import com.example.cloudstream.personChannel.service.PersonMq;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Resource
    PersonMq personMq;

    @RequestMapping("/send")
    public String send(String name, Integer age) {
        personMq.send(new Person(name, age));
        return "发送成功";
    }
}
