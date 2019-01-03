package com.learnspringboot.learnSubject.schedule.async;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest

public class AsyncServiceTest {

    @Resource
    AsyncService asyncService;

    @Test
    public void asyncMethod() throws InterruptedException {
        System.out.println("开始异步方法调用");
        asyncService.asyncMethod();
        System.out.println("结束异步方法调用");
        TimeUnit.SECONDS.sleep(3L);
    }
}