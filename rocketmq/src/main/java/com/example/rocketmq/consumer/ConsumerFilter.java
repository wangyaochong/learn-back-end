package com.example.rocketmq.consumer;

import com.example.rocketmq.config.ConfigProperties;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

public class ConsumerFilter {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1");
        consumer.setNamesrvAddr(ConfigProperties.namesrvAddr);
        consumer.subscribe("FilterTopic", MessageSelector.bySql("i>5"));
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
