package com.example.cloudstream.testForWork;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface WorkChannel {
    String input = "settle-input";
    String output = "settle-output";

    //
    @Input(input)
    SubscribableChannel input();

    @Output(output)
    MessageChannel output();
}
