package com.example.mockitopower.service;

import com.example.mockitopower.common.User;
import com.example.mockitopower.dao.UserDao;
import com.example.mockitopower.dao.UserDaoFinal;

public class UserServiceFinal {


    public int queryUserCount() {
        return new UserDaoFinal().getCount();
    }

    public void saveUser(User user) {
        new UserDaoFinal().insertUser(user);
    }
}
