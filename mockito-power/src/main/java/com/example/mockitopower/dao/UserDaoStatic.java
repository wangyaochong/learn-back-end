package com.example.mockitopower.dao;

import com.example.mockitopower.common.User;

public class UserDaoStatic {
    public static int getCount() {
        throw new RuntimeException("数据库不可用");
    }

    public static void insertUser(User user) {
        throw new RuntimeException("数据库不可用");
    }
}
