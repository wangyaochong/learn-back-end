package com.learnspringboot.basePackage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/cache")
@Slf4j
public class CacheController {
    @Resource
    RedisTemplate<String, String> redisTemplate;


    @GetMapping("/get")
    public Object get(String key) {
        log.info("key={}", key);
        Object o = redisTemplate.opsForValue().get(key);
        log.info("value={}", o);
        return o;
    }

    @GetMapping("/set")
    public String set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        return "success";
    }


}
