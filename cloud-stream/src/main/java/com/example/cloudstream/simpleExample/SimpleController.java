package com.example.cloudstream.simpleExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/simple")
@EnableBinding(value = {Source.class})
public class SimpleController {

    @Autowired
    private Source source;

    @GetMapping("/send")
    public String send(){
        source.output().send(MessageBuilder.withPayload("{name:'hello',age:16}").build());
        return "发送成功";
    }
}
