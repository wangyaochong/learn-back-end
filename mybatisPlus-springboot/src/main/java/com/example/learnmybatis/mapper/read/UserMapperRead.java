package com.example.learnmybatis.mapper.read;

import com.example.learnmybatis.entity.User;

import java.util.List;

public interface UserMapperRead {
    User selectUserById(Integer integer);

    List<User> selectAllUser();

    void updateUserById(User user);
}

