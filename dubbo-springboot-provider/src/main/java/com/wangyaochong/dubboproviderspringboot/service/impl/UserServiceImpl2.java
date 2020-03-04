package com.wangyaochong.dubboproviderspringboot.service.impl;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import wangyaochong.bean.UserAddress;
import wangyaochong.service.UserService;

import java.util.ArrayList;
import java.util.List;


//@Service(version = "2.0", timeout = 60000)//暴露服务
//@Component
public class UserServiceImpl2 implements UserService {
    @HystrixCommand
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("newVersion");
        ArrayList<UserAddress> addressList = new ArrayList<>();
        addressList.add(new UserAddress(1, "北京", 18));
        addressList.add(new UserAddress(2, "上海", 18));
        addressList.add(new UserAddress(3, "南昌", 18));

        if (Math.random() > 0.5) {
            throw new RuntimeException("随机出错");
        }
        return addressList;
    }
}
