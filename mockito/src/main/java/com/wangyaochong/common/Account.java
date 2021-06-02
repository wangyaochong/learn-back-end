package com.wangyaochong.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangyaochong
 * date 2020/5/2 13:29
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Account {
    String username;
    String password;

    public void sayHello() {
        throw new RuntimeException();
    }

    public String testGet() {
        return TEST;
    }

    public static final String TEST = "test";
}
