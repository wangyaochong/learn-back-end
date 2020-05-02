package com.wangyaochong.mockMethod;

import com.wangyaochong.common.Account;
import com.wangyaochong.common.AccountDao;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * @author wangyaochong
 * date 2020/5/2 14:10
 */
public class WithMockitoRule {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testMock() {
        AccountDao dao = Mockito.mock(AccountDao.class);
        Account abc = dao.findAccount("abc", "123");
        System.out.println(abc);
    }

}
