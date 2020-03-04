package com.wangyaochong.dubboconsumerspringboot.stub;

import org.apache.logging.log4j.util.Strings;
import wangyaochong.bean.UserAddress;
import wangyaochong.service.UserService;

import java.util.List;


public class UserServiceStub implements UserService {
    private UserService userService;

    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("调用本地存根");
        if (!Strings.isBlank(userId)) {
            return userService.getUserAddressList(userId);
        }
        return null;
    }
}
