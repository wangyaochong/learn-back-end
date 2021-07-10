package com.example.rocketmq.producer;

import com.example.rocketmq.config.ConfigProperties;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.concurrent.TimeUnit;

public class ProducerTransaction {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        TransactionMQProducer producer = new TransactionMQProducer("group1");
        producer.setNamesrvAddr(ConfigProperties.namesrvAddr);
        producer.setSendMsgTimeout(10000);
        producer.setTransactionListener(new TransactionListener() {
            @Override public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
                if (msg.getTags().equals("tagA")) {
                    return LocalTransactionState.COMMIT_MESSAGE;
                } else if (msg.getTags().equals("tagB")) {
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                } else if (msg.getTags().equals("tagC")) {
                    return LocalTransactionState.UNKNOW;
                }
                return LocalTransactionState.UNKNOW;
            }

            @Override public LocalTransactionState checkLocalTransaction(MessageExt msg) {
                System.out.println("回查消息的tag=" + msg.getTags());
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });
        producer.start();
        String[] tags = {"tagA", "tagB", "tagC"};
        for (int i = 0; i < 3; i++) {
            Message msg = new Message("TransactionTopic", tags[i], ("helloWorld" + i).getBytes());
            TransactionSendResult result = producer.sendMessageInTransaction(msg, null);
            String format = String.format("发送状态=%s", result);
            System.out.println(format);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
