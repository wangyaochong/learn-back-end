package com.example.rocketmq.producer;

import com.example.rocketmq.config.ConfigProperties;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.concurrent.TimeUnit;

public class ProducerOneway {
    public static void main(String[] args) throws MQClientException, InterruptedException, MQBrokerException, RemotingException {
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr(ConfigProperties.namesrvAddr);
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message msg = new Message("base", "tag3", ("helloWorld，单向" + i).getBytes());
            producer.sendOneway(msg);
//            String format = String.format("发送状态=%s", result);
//            System.out.println(format);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("发送消息="+i);
        }
    }
}
