package com.example.mockitopower.service;

import com.example.mockitopower.common.User;
import com.example.mockitopower.dao.UserDao;
import com.example.mockitopower.dao.UserDaoStatic;

public class UserServiceStatic {
    public int queryUserCount() {
        return UserDaoStatic.getCount();
    }

    public void saveUser(User user) {
        UserDaoStatic.insertUser(user);
    }
}
