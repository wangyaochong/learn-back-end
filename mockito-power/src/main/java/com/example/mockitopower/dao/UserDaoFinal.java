package com.example.mockitopower.dao;

import com.example.mockitopower.common.User;

public final class UserDaoFinal {
    public int getCount() {
        throw new RuntimeException("数据库不可用");
    }

    public void insertUser(User user) {
        throw new RuntimeException("数据库不可用");
    }
}
