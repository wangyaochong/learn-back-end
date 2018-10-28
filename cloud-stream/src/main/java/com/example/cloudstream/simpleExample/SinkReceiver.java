package com.example.cloudstream.simpleExample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
@EnableBinding(value = {Sink.class})
@Slf4j
public class SinkReceiver {
    @StreamListener(Sink.INPUT)
    public void receive(String payload) {
        log.info("Received: " + payload);
    }
}
