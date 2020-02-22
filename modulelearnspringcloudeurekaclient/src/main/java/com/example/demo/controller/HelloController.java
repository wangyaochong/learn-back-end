package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import util.UtilLog;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class HelloController {

    @Resource
    DiscoveryClient discoveryClient;

    @RequestMapping(value = "/helloClient", method = RequestMethod.GET)
    public String index() {

        List<ServiceInstance> instances = discoveryClient.getInstances("test-service");
        for (ServiceInstance instance : instances) {
            log.info(UtilLog.prefixLog("服务名称={}"), instance.getServiceId());
            log.info(UtilLog.prefixLog("服务host={}"), instance.getHost());
            log.info(UtilLog.prefixLog("服务port={}"), instance.getPort());
        }
        return "hello";
    }
}
