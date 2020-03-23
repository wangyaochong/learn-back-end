package com.wangyaochong.springsecurityboot;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * @author wangyaochong
 * @date 2020/3/23 17:50
 */
public class SimpleTest {
    @Test
    public void test() {
        String hashpw = BCrypt.hashpw("1123", BCrypt.gensalt());
        String hashpw2 = BCrypt.hashpw("1123", BCrypt.gensalt());
        System.out.println(hashpw);
        System.out.println(hashpw2);
        System.out.println(BCrypt.checkpw("1123", hashpw));
        System.out.println(BCrypt.checkpw("1123", hashpw2));
    }
}
