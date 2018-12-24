package com.example.cloudstream.testForWork;

import com.example.cloudstream.personChannel.bean.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/work")
public class WorkController {


    @Resource
    WorkMq workMq;

    @RequestMapping("/send")
    public String send(String name, Integer age) {
        workMq.send(new Person(name, age));
        return "发送成功";
    }

    @RequestMapping("/sendString")
    public String sendString(String name, Integer age) {
        workMq.sendString(new Person(name, age));
        return "发送成功";
    }
}


