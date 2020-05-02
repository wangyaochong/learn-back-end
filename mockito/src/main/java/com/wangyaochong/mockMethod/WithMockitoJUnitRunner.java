package com.wangyaochong.mockMethod;

import com.wangyaochong.common.Account;
import com.wangyaochong.common.AccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author wangyaochong
 * date 2020/5/2 14:01
 */
@RunWith(MockitoJUnitRunner.class)
public class WithMockitoJUnitRunner {
    @Test
    public void testMock() {
        AccountDao accountDao = Mockito.mock(AccountDao.class, Mockito.RETURNS_SMART_NULLS);
//        Mockito.when(accountDao.findAccount("abc", "123")).thenReturn(new Account("abc", "123"));
        Account abc = accountDao.findAccount("abc", "123");
        System.out.println(abc);
    }


    @Test
    public void testMock2() {
        AccountDao accountDao = Mockito.mock(AccountDao.class, Mockito.RETURNS_DEEP_STUBS);
//        Mockito.when(accountDao.findAccount("abc", "123")).thenReturn(new Account("abc", "123"));
        Account abc = accountDao.findAccount("abc", "123");
        System.out.println(abc);
    }
}
