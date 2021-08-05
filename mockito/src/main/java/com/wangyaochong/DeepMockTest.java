package com.wangyaochong;

import com.wangyaochong.common.Account;
import com.wangyaochong.common.AccountDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

/**
 * @author wangyaochong
 * date 2020/5/2 14:07
 */
@RunWith(MockitoJUnitRunner.class)
public class DeepMockTest {

    @Mock
    AccountDao accountDao;
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    AccountDao accountDaoDeep;
    @Mock
    Account account;


    @Before
    public void before() {
        when(account.testGet()).thenReturn("test");
    }

    @Test
    public void testWithError() {
        accountDao.getOne().sayHello();
    }

    @Test
    public void testWithOutDeep() {
        when(accountDao.getOne()).thenReturn(account);
        Account one = accountDao.getOne();
        one.sayHello();
    }

    @Test
    public void testWithDeep() {
        System.out.println(accountDaoDeep.getOne().testGet());;
        accountDaoDeep.getOne().sayHello();
    }
}
