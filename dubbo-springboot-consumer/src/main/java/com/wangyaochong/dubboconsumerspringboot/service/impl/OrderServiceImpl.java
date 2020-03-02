package com.wangyaochong.dubboconsumerspringboot.service.impl;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import wangyaochong.bean.UserAddress;
import wangyaochong.service.OrderService;
import wangyaochong.service.UserService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Reference
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        return userService.getUserAddressList(userId);
    }
}
