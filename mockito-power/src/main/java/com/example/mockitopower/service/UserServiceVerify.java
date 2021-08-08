package com.example.mockitopower.service;

import com.example.mockitopower.common.User;
import com.example.mockitopower.dao.UserDao;

public class UserServiceVerify {
    public void saveOrUpdate(User user){
        UserDao userDao = new UserDao();
        if(userDao.getCount(user)>0){
            userDao.updateUser(user);
        }else{
            userDao.insertUser(user);
        }
    }
}
