package com.example.mockitopower.service;

import com.example.mockitopower.common.User;
import com.example.mockitopower.dao.UserDao;

public class UserServiceNoInit {


    public int queryUserCount() {
        return new UserDao().getCount();
    }

    public void saveUser(User user) {
        new UserDao().insertUser(user);
    }

    public String queryByName(String name) {
        return new UserDao().queryByName(name);
    }

    public void log(String param) {
        new UserDao().log(param);
    }

    public boolean exist(String username) {
        return checkExist(username);
    }

    private boolean checkExist(String username) {
        throw new RuntimeException("数据库执行时间太长");
    }
}
