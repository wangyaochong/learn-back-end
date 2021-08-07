package com.wangyaochong.mockFieldAndNew;

public class MyService {
    MyDbOpertation dbOpertation = new MyDbOpertation();

    public String operateDb() {
        return dbOpertation.dbOperation();
    }
}
