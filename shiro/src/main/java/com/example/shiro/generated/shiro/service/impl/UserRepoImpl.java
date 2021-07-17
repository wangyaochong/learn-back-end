package com.example.shiro.generated.shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shiro.generated.shiro.entity.User;
import com.example.shiro.generated.shiro.mapper.UserMapper;
import com.example.shiro.generated.shiro.service.UserRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shiro.util.UtilSalt;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mybatis-plus generated
 * @since 2021-07-13
 */
@Service
public class UserRepoImpl extends ServiceImpl<UserMapper, User> implements UserRepo {

    @Override public void register(User user) {
        String salt = UtilSalt.getSalt(8);
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), salt,1024);
        user.setSalt(salt);
        user.setPassword(md5Hash.toHex());
        save(user);
    }

    @Override public User findByUserName(String name) {
        return this.getOne(new QueryWrapper<User>().eq("username", name));
    }
}
