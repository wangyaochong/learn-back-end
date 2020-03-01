package com.example.learnmybatis.mapper.write;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.learnmybatis.entity.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    User selectUserById(Integer integer);

    List<User> selectAllUser();

    void updateUserById(User user);
}
