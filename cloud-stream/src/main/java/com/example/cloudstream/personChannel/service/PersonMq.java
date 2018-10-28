package com.example.cloudstream.personChannel.service;
import com.example.cloudstream.personChannel.bean.Person;
import com.example.cloudstream.personChannel.interfaces.PersonChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@EnableBinding(PersonChannel.class)
@Slf4j
public class PersonMq {

    @Resource
    PersonChannel personChannel;

    @StreamListener(PersonChannel.input)
    public void receive(Person person){
        log.info("收到消息：{}",person);
    }
    public void send(Person person){
        personChannel.output().send(MessageBuilder.withPayload(person).build());
    }
}
