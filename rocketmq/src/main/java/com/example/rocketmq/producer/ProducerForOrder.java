package com.example.rocketmq.producer;

import com.example.rocketmq.config.ConfigProperties;
import com.example.rocketmq.order.OrderStep;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProducerForOrder {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr(ConfigProperties.namesrvAddr);
        producer.start();
        List<OrderStep> orderSteps = OrderStep.buildOrders();
        for (int i = 0; i < orderSteps.size(); i++) {
            OrderStep step = orderSteps.get(i);
            String body = step + "";
            Message msg = new Message("OrderTopic", "order", "i" + i, body.getBytes());
            SendResult result = producer.send(msg, (list, message, o) -> {
                int orderId = (int) o;
                return list.get(orderId % list.size());
            }, step.getOrderId(),10000);
            String format = String.format("发送结果=%s", result);
            System.out.println(format);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
