package com.example.springinner.springEvent.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class TestService {

    @PostConstruct
    public void init() {
        log.info("TestService init");
    }

}
