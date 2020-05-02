package com.wangyaochong.mockMethod;

import com.wangyaochong.common.Account;
import com.wangyaochong.common.AccountDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author wangyaochong
 * date 2020/5/2 14:08
 */
public class WithMockitoAnnotations {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    AccountDao accountDao;

    @Test
    public void testMock() {
        Account abc = accountDao.findAccount("abc", "123");
        System.out.println(abc);
    }
}
