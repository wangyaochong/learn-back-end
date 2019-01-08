package com.learnspringboot.learnSubject.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Service
@Slf4j
public class MyRedisLock {
    @Resource
    RedisTemplate redisTemplate;
    private final String lockValue = "1";

    @PostConstruct
    public void init() {
        log.info("redis lock初始化了");
    }

    public String testEval() {
        byte[] execute = (byte[]) redisTemplate.execute((RedisCallback) connection ->
                connection.eval("return KEYS[1]..'='..ARGV[1]..','..KEYS[2]..'='..ARGV[2] ".getBytes(),
                        ReturnType.VALUE, 2, "key1".getBytes(), "key2".getBytes(), "value1".getBytes(), "value2".getBytes()));
        return new String(execute);
    }

    public boolean tryLockEval(String key, int seconds) {
        /**
         * 对于redis集群，需要key哈希后的slot要相同
         */
        return (boolean) redisTemplate.execute((RedisCallback) connection ->
                //返回值是数字1，不是字符串"1"，这个需要注意！
                connection.eval("if redis.call('setnx',KEYS[1],ARGV[1])==1 then return  redis.call('expire' , KEYS[1] , ARGV[2]) else return 0 end".getBytes(),
                        ReturnType.BOOLEAN, 2, key.getBytes(), "expire".getBytes(), lockValue.getBytes(), Integer.toString(seconds).getBytes()));
    }

    public boolean tryLock(String key, int seconds) {
        return (boolean) redisTemplate.execute((RedisCallback) connection ->
                connection.set(key.getBytes(), lockValue.getBytes(), Expiration.seconds(seconds), RedisStringCommands.SetOption.SET_IF_ABSENT));
    }

    public boolean unLock(String key) {
        return (boolean) redisTemplate.execute((RedisCallback) connection ->
                connection.eval("if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end".getBytes(),
                        ReturnType.BOOLEAN, 1, key.getBytes(), lockValue.getBytes()));
    }

    public boolean unLockTest() {
        return (boolean) redisTemplate.execute((RedisCallback) connection ->
                connection.eval("if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end".getBytes(),
                        ReturnType.BOOLEAN, 1, "lock".getBytes(), lockValue.getBytes()));
    }
}
