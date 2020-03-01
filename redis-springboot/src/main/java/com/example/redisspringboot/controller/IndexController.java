package com.example.redisspringboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.UUID;

@Slf4j
@RestController
public class IndexController {

    @Autowired
    RedissonClient redissonClient;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping(value = "decrStockSave")
    public String decrStockSave() {//使用redisson真的太简单了
        String stockKey = "stock";
        String lockKey = stockKey + "processing";
        RLock lock = redissonClient.getLock(lockKey);
        try {
            lock.lock();
            String result = stringRedisTemplate.opsForValue().get(stockKey);
            assert result != null;
            int stock = Integer.parseInt(result);
            if (stock > 0) {
                stock = stock - 1;
                stringRedisTemplate.opsForValue().set(stockKey, String.valueOf(stock));
                processDb(stock);
            } else {
                System.out.println("库存不足");
            }
        } finally {
            lock.unlock();
        }
        return "end";
    }

    @GetMapping(value = "decrStock")
    public String decrStock() {
        //这个代码还是有问题的，因为其他线程没有阻塞延迟时间，会导致用户点击可能失效
        String stockKey = "stock";
        String uuid = UUID.randomUUID().toString();
        String lockKey = stockKey + "processing";
        if (!stringRedisTemplate.opsForValue().setIfAbsent(lockKey, uuid, Duration.ofSeconds(60))) {
            System.out.println("被阻塞，扣减库存失败");
            return "error";
        }
        String result = stringRedisTemplate.opsForValue().get(stockKey);
        assert result != null;
        int stock = Integer.parseInt(result);
        if (stock > 0) {
            try {
                stock = stock - 1;
                stringRedisTemplate.opsForValue().set(stockKey, String.valueOf(stock));
                processDb(stock);
            } finally {
                if (uuid.equals(stringRedisTemplate.opsForValue().get(lockKey))) {
                    stringRedisTemplate.delete(lockKey);
                }
            }
        } else {
            System.out.println("没有库存，无法扣减");
        }
        return "end";
    }

    public void processDb(int realStock) {
        System.out.println("数据库扣减成功，剩余库存：" + realStock);
    }

}
