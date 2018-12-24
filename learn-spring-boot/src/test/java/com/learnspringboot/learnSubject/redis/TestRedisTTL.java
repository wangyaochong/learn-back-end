package com.learnspringboot.learnSubject.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestRedisTTL {


    @Resource
    RedisTemplate redisTemplate;

    @Test
    public void testSet() {
        redisTemplate.opsForValue().set("test", "test");
        redisTemplate.expire("test", 40, TimeUnit.SECONDS);
    }

    @Test
    public void testGet() {
        System.out.println(redisTemplate.opsForValue().get("test"));//ttl并不会因为get重置

    }
}
