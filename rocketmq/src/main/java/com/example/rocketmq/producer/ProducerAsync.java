package com.example.rocketmq.producer;

import com.example.rocketmq.config.ConfigProperties;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.concurrent.TimeUnit;

// https://www.bilibili.com/video/BV1L4411y7mn?p=20&spm_id_from=pageDriver
public class ProducerAsync {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr(ConfigProperties.namesrvAddr);
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message msg = new Message("base", "tag2", ("helloWorld" + i).getBytes());
            producer.send(msg, new SendCallback() {
                @Override public void onSuccess(SendResult sendResult) {
                    System.out.println("发送结果="+sendResult);
                }

                @Override public void onException(Throwable throwable) {
                    System.out.println("发送异常=" + throwable);
                }
            });
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
