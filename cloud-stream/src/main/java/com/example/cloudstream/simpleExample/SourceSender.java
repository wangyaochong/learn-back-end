package com.example.cloudstream.simpleExample;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@EnableBinding(value = {Source.class})
@Service
public class SourceSender {

    @Resource
    private Source source;


    public void sayHello(String name) {
        source.output().send(MessageBuilder.withPayload(name).build());
    }
}
