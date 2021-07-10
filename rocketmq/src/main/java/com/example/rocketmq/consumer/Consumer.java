package com.example.rocketmq.consumer;

import com.example.rocketmq.config.ConfigProperties;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import java.util.List;
public class Consumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1");
        consumer.setNamesrvAddr(ConfigProperties.namesrvAddr);
        consumer.subscribe("base", "tag1");
//        consumer.setMessageModel(MessageModel.BROADCASTING);
        consumer.registerMessageListener((MessageListenerOrderly) (list, consumeOrderlyContext) -> {
            for (MessageExt messageExt : list) {
                System.out.println("body=" + new String(messageExt.getBody()));
            }
            return ConsumeOrderlyStatus.SUCCESS;
        });
        consumer.start();
    }
}
