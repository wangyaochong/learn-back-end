package com.example.mockitopower.service;

import com.example.mockitopower.dao.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserServiceNoInit.class)
public class UserServiceTestArgumentMatcher {
    @Test
    public void test() throws Exception {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        UserServiceNoInit userService = new UserServiceNoInit();

        PowerMockito.when(userDao.queryByName("abc")).thenReturn("abc");
        String abc = userService.queryByName("abc");
        Assert.assertEquals(abc, "abc");

        PowerMockito.when(userDao.queryByName("xyz")).thenReturn("xyz");
        String xyz = userService.queryByName("xyz");
        Assert.assertEquals(xyz, "xyz");
    }

    @Test
    public void testWithMatch() throws Exception {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        UserServiceNoInit userService = new UserServiceNoInit();

        //可以匹配多个参数
        PowerMockito.when(userDao.queryByName(ArgumentMatchers.argThat(new MyArgumentMatch())))
                .thenReturn("abc");
        String abc = userService.queryByName("abc");
        Assert.assertEquals(abc, "abc");
        String abc1 = userService.queryByName("xyz");
        Assert.assertEquals(abc1, "abc");
    }

    @Test
    public void testWithAnswer() throws Exception {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);

        PowerMockito.when(userDao.queryByName(Mockito.anyString())).then(invocation -> {
            String argument = (String) invocation.getArguments()[0];
            switch (argument) {
                case "jacky":
                    return "hello jacky";
                case "alex":
                    return "hello alex";
                default:
                    throw new RuntimeException("异常");
            }
        });
        UserServiceNoInit userService = new UserServiceNoInit();
        String jacky = userService.queryByName("jacky");
        Assert.assertEquals(jacky, "hello jacky");

        String alex = userService.queryByName("alex");
        Assert.assertEquals(alex, "hello alex");

    }

    static class MyArgumentMatch implements ArgumentMatcher<String> {
        @Override public boolean matches(String argument) {
            switch (argument) {
                case "abc":
                case "xyz":
                    return true;
            }
            return false;
        }
    }
}
