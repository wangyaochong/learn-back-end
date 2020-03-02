package com.wangyaochong.dubboproviderspringboot.service.impl;


import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import wangyaochong.bean.UserAddress;
import wangyaochong.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service//暴露服务
@Component
public class UserServiceImpl implements UserService {
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        ArrayList<UserAddress> addressList = new ArrayList<>();
        addressList.add(new UserAddress(1, "北京", 18));
        addressList.add(new UserAddress(2, "上海", 18));
        addressList.add(new UserAddress(3, "南昌", 18));
        return addressList;
    }
}
