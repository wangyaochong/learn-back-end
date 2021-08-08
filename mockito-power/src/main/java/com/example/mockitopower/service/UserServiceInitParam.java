package com.example.mockitopower.service;

import com.example.mockitopower.dao.UserDao;
import com.example.mockitopower.dao.UserDaoInitParam;

public class UserServiceInitParam {
    public void save(String userName, String password) {
        new UserDaoInitParam(userName, password).save();
    }

}
