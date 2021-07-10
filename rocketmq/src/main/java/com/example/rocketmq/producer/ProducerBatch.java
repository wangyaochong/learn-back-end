package com.example.rocketmq.producer;

import com.example.rocketmq.config.ConfigProperties;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProducerBatch {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr(ConfigProperties.namesrvAddr);
        producer.start();
        List<Message> msgList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            msgList.add(new Message("base", "tag1", ("helloWorld" + i).getBytes()));
        }
        SendResult result = producer.send(msgList, 10000);
        String format = String.format("发送状态=%s", result);
        System.out.println(format);
        TimeUnit.SECONDS.sleep(1);

    }
}
