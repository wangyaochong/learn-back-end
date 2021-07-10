package com.example.rocketmq.producer;

import com.example.rocketmq.config.ConfigProperties;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.concurrent.TimeUnit;

public class ProducerDelayed {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr(ConfigProperties.namesrvAddr);
        producer.start();
        for (int i = 0; i < 100; i++) {
            Message msg = new Message("base", "tag1", ("helloWorld" + i).getBytes());
            msg.setDelayTimeLevel(3);//延时10s
            SendResult result = producer.send(msg, 10000);
            String format = String.format("发送状态=%s", result);
            System.out.println(format);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
