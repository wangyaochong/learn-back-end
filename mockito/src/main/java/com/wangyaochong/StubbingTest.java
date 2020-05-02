package com.wangyaochong;

import com.wangyaochong.common.Account;
import com.wangyaochong.common.AccountDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * @author wangyaochong
 * date 2020/5/2 14:37
 */
@RunWith(MockitoJUnitRunner.class)
public class StubbingTest {

    @Mock
    List<String> list;

    @Before
    public void before() {

    }

    @After
    public void after() {

    }

    @Test
    public void testGetStubbing() {
        when(list.get(0)).thenReturn("first");
        assertThat(list.get(0), equalTo("first"));

        when(list.get(anyInt())).thenThrow(new RuntimeException());
        try {
            list.get(0);
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(RuntimeException.class));
        }
    }

    @Test
    public void testVoidStubbing() {
        doNothing().when(list).clear();
        list.clear();
        verify(list, times(1)).clear();
        try {

            doThrow(RuntimeException.class).when(list).clear();
        } catch (Exception e) {
            assertThat(e, instanceOf(RuntimeException.class));
        }
    }

    @Test
    public void testDoReturn() {
        when(list.get(0)).thenReturn("first");
        doReturn("second").when(list).get(1);
        assertThat(list.get(0), equalTo("first"));
        assertThat(list.get(1), equalTo("second"));
    }

    @Test
    public void testIterateStubbing() {
        when(list.size()).thenReturn(1, 2, 3, 4);
//        when(list.size()).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4); //等价
        assertThat(list.size(), equalTo(1));
        assertThat(list.size(), equalTo(2));
        assertThat(list.size(), equalTo(3));
        assertThat(list.size(), equalTo(4));
        assertThat(list.size(), equalTo(4));
    }

    @Test
    public void testWithAnswer() {
        when(list.get(anyInt())).thenAnswer((mock) -> {
            Integer argument = mock.getArgument(0, Integer.class);
            return String.valueOf(argument * 10);
        });
        System.out.println(list.get(1));
    }

    @Test
    public void testWithRealCall() {//可用于只想部分进行mock的操作
        AccountDao accountDao = mock(AccountDao.class);
        Account one = accountDao.getOne();
        System.out.println(one);
        when(accountDao.getOne()).thenCallRealMethod();
        Account one1 = accountDao.getOne();
        System.out.println(one1);
    }

}
