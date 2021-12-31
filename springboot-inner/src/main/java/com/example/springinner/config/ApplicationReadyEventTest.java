package com.example.springinner.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationReadyEventTest implements ApplicationListener<ApplicationReadyEvent> {
    @Override public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("applicationReady");
//        throw new RuntimeException("applicationReady exception");
    }
}
