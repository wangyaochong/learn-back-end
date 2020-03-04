package com.wangyaochong.dubboconsumerspringboot.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import wangyaochong.bean.UserAddress;
import wangyaochong.service.OrderService;
import wangyaochong.service.UserService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    @Reference(version = "2.0", stub = "com.wangyaochong.dubboconsumerspringboot.stub.UserServiceStub",
            timeout = 1000,
            //取值参考 http://dubbo.apache.org/zh-cn/docs/user/demos/loadbalance.html
            //可以在配置中心进行配置
            loadbalance = "random",
            mock = "fail:return+null",
            //目前methods注解好像不生效
            methods = {@Method(name = "getUserAddressList", retries = 1, timeout = 1000)}
    )
    UserService userService;

    @HystrixCommand(fallbackMethod = "hello")
    @Override
    public List<UserAddress> initOrder(String userId) {
        return userService.getUserAddressList(userId);
    }

    public List<UserAddress> hello(String userId) {
        System.out.println("调用initOrder容错方法hello");
        return null;
    }
}
