package com.example.mockitopower.dao;

import com.example.mockitopower.common.User;

public class UserDao {
    public UserDao() {

    }

    public int getCount() {
        throw new RuntimeException("数据库不可用");
    }

    public int getCount(User user) {
        throw new RuntimeException("数据库不可用");
    }

    public void insertUser(User user) {
        throw new RuntimeException("数据库不可用");
    }

    public void updateUser(User user) {
        throw new RuntimeException("数据库不可用");
    }

    public String queryByName(String name) {
        throw new RuntimeException("数据库不可用");
    }

    public void log(String param) {
        System.out.println("这是日志，param=" + param);
    }
}
