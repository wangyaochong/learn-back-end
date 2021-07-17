package com.example.shiro.generated.shiro.service;

import com.example.shiro.generated.shiro.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mybatis-plus generated
 * @since 2021-07-13
 */
public interface UserRepo extends IService<User> {

    public void register(User user);

    public User findByUserName(String name);
}
