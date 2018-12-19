package com.learnspringboot.learnSubject.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestRedisLock {
    @Resource
    MyRedisLock redisLock;

    @Test
    public void test() throws InterruptedException {
        if (redisLock.tryLockEval("lock", 60)) {
            log.info("加锁成功");
            TimeUnit.SECONDS.sleep(5);
            if (redisLock.unLock("lock")) {
                log.info("解锁成功");
            } else {
                log.info("解锁失败");
            }
        } else {
            log.info("加锁失败");
        }
    }

    ExecutorService executorService = Executors.newFixedThreadPool(20);

    @Test
    public void testMultiThread() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                if (redisLock.tryLockEval("lock", 30)) {
                    log.info("加锁成功");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (redisLock.unLock("lock")) {
                        log.info("解锁成功");
                    } else {
                        log.info("解锁失败");
                    }
                } else {
                    log.info("加锁失败");
                }
            });
            if (i % 10 == 9) {
                TimeUnit.SECONDS.sleep(1);
            }
        }
        executorService.shutdown();
        executorService.awaitTermination(200, TimeUnit.SECONDS);
    }


    @Test
    public void testEval() {
        System.out.println(redisLock.testEval());
    }

}
