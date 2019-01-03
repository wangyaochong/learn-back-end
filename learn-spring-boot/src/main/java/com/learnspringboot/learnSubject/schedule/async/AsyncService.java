package com.learnspringboot.learnSubject.schedule.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class AsyncService {

    @Async
    public void asyncMethod() {
        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("asyncMethod执行了2秒");
    }
}
