package com.wangyaochong.common;

/**
 * @author wangyaochong
 * date 2020/5/2 13:29
 */
public class AccountDao {
    public Account findAccount(String username, String password) {
        throw new UnsupportedOperationException();
    }

    public Account getOne() {
        return new Account("one", "1");
    }
}
