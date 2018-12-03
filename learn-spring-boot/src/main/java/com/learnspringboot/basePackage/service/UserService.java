package com.learnspringboot.basePackage.service;

import entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Cacheable(value = "userCache")
    public User getUserByName(String name) {
        log.info("从数据库查询name={}的用户", name);
        return new User(1L, name, name, name, null);
    }
}
