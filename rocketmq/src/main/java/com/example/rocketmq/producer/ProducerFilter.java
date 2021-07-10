package com.example.rocketmq.producer;

import com.example.rocketmq.config.ConfigProperties;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.concurrent.TimeUnit;

public class ProducerFilter {
    public static void main(String[] args) throws InterruptedException, MQBrokerException, RemotingException, MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr(ConfigProperties.namesrvAddr);
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message msg = new Message("FilterTopic", "tag1", ("helloWorld" + i).getBytes());
            msg.putUserProperty("i", String.valueOf(i));

            SendResult result = producer.send(msg, 10000);
            String format = String.format("发送状态=%s", result);
            System.out.println(format);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
