package com.wangyaochong;

import com.wangyaochong.common.Account;
import com.wangyaochong.common.AccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

/**
 * @author wangyaochong
 * date 2020/5/2 15:11
 */
@RunWith(MockitoJUnitRunner.class)
public class SpyTest {

    //spy默认使用real call，除非使用stub，也就是可以实现部分mock
    @Spy
    AccountDao accountDao;

    @Test
    public void testSpy() {
        Account one = accountDao.getOne();
        System.out.println(one);
        when(accountDao.getOne()).thenReturn(new Account("mock", "mock"));
        Account one1 = accountDao.getOne();
        System.out.println(one1);
    }
}
