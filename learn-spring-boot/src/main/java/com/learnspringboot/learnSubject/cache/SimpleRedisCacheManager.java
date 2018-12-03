package com.learnspringboot.learnSubject.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SimpleRedisCacheManager implements CacheManager {


    @Override
    public Cache getCache(String name) {

        return null;
    }

    @Override
    public Collection<String> getCacheNames() {
        return null;
    }
}
