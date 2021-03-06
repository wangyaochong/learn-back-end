package com.example.cloudstream.testForWork;

import com.alibaba.fastjson.JSON;
import com.example.cloudstream.personChannel.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@EnableBinding(WorkChannel.class)
@Slf4j
public class WorkMq {

    @Resource
    WorkChannel workChannel;

    @StreamListener(WorkChannel.input)
    public void receive(Person person) {
        log.info("收到消息：{}", person);

//         如果是抛异常，则消息可以重试3次，如果还是失败，则在程序运行期间不再处理，程序重启后还能收到该消息，重试次数可以配置
//        throw new RuntimeException("测试消息是否重发person=" + person);
    }

    public void send(Person person) {
        workChannel.output().send(MessageBuilder.withPayload(person).build());
    }

    public void sendString(Person person) {
        workChannel.output().send(MessageBuilder.withPayload(JSON.toJSONString(person)).build());
    }
}
