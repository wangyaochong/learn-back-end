package com.example.cloudstream.personChannel.controller;

import com.example.cloudstream.personChannel.service.PersonMq;
import com.example.cloudstream.personChannel.bean.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Resource
    PersonMq personMq;

    @RequestMapping("/send")
    public String send(){
        personMq.send(new Person("王耀冲",25));
        return "发送成功";
    }
}
