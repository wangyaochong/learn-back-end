package com.example.mockitopower.dao;

public class UserDaoInitParam {
    String userName;
    String password;

    public UserDaoInitParam(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void save() {
        throw new RuntimeException();
    }

}
