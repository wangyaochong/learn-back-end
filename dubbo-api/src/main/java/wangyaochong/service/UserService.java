package wangyaochong.service;


import wangyaochong.bean.UserAddress;

import java.util.List;

public interface UserService {
    /**
     * 按照用户id返回收货地址
     *
     * @param userId 用户id
     * @return 地址列表
     */
    public List<UserAddress> getUserAddressList(String userId);

}
