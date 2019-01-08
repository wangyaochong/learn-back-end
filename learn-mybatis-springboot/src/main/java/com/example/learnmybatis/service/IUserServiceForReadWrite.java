package com.example.learnmybatis.service;

import com.example.learnmybatis.entity.User;

public interface IUserServiceForReadWrite {
    void writeUpdateUserMultiMapper(User user);

    void readUpdateUserMultiMapper(User user);

    void annoUpdateUser(User user);


    User selectById(Integer id);
}
