package wangyaochong.service;

import wangyaochong.bean.UserAddress;

import java.util.List;

public interface OrderService {

    List<UserAddress> initOrder(String userId);

}
