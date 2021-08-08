package com.example.mockitopower.service;

import com.example.mockitopower.common.User;
import com.example.mockitopower.dao.UserDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;

public class UserServiceTest {

    @Test
    public void queryUserCountWithJunit() {
        UserService userService = new UserService(new UserDao());
        //会失败
        userService.queryUserCount();
    }

    @Mock
    UserDao userDao;

    @Test
    public void queryUserCountWithMockito() {
        MockitoAnnotations.initMocks(this);//让mock注解生效
//        UserDao userDao = Mockito.mock(UserDao.class);
        Mockito.when(userDao.getCount()).thenReturn(0);
        UserService userService = new UserService(userDao);
        int i = userService.queryUserCount();
        Assertions.assertEquals(i, 0);
    }

    @Test
    public void testSaveUserWithPowerMock() {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        User user = new User();
        PowerMockito.doNothing().when(userDao).insertUser(user);
        UserService userService = new UserService(userDao);
        userService.saveUser(user);
        Mockito.verify(userDao).insertUser(user);
    }

    @Test
    public void saveUserWithJunit() {
    }
}