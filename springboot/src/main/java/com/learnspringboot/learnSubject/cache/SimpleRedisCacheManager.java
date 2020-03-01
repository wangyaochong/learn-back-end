//package com.learnspringboot.learnSubject.cache;
//
//import org.springframework.cache.Cache;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.concurrent.ConcurrentMapCache;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.Collections;
//
//@Service
//public class SimpleRedisCacheManager implements CacheManager {
//
//
//    ConcurrentMapCache concurrentMapCache = new ConcurrentMapCache("userCache");
//    @Override
//    public Cache getCache(String name) {
//        if (name.equals("userCache")) {
//            return concurrentMapCache;
//        }
//        return null;
//    }
//
//    @Override
//    public Collection<String> getCacheNames() {
//        return Collections.singletonList("userCache");
//    }
//}
