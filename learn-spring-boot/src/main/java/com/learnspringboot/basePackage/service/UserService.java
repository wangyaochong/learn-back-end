package com.learnspringboot.basePackage.service;

import entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@CacheConfig(cacheNames = "userCache")//对于多个方法使用同一个缓存时，可以使用该注解，对类有效
public class UserService {

    @Cacheable
    public User getUserByName(String name) {
        log.info("从数据库查询name={}的用户", name);
        return new User(1L, name, name, name, null);
    }

    @CacheEvict(allEntries = true)
    public void updateUser() {
        log.info("updateUser and clear cache");
    }
}
