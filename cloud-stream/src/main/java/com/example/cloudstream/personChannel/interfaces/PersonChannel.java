package com.example.cloudstream.personChannel.interfaces;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


public interface PersonChannel {
    String input = "person-input";
    String output = "person-output";

    @Input(input)
    SubscribableChannel input();

    @Output(output)
    MessageChannel output();

}
