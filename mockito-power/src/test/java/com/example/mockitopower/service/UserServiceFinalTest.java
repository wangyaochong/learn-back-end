package com.example.mockitopower.service;

import com.example.mockitopower.dao.UserDao;
import com.example.mockitopower.dao.UserDaoFinal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserServiceFinal.class,UserDaoFinal.class})
public class UserServiceFinalTest {

       @Test
    public void queryUserCount() throws Exception {
        UserDaoFinal userDao = PowerMockito.mock(UserDaoFinal.class);
        PowerMockito.whenNew(UserDaoFinal.class).withNoArguments().thenReturn(userDao);
        PowerMockito.doReturn(10).when(userDao).getCount();
        UserServiceFinal userService = new UserServiceFinal();
        int i = userService.queryUserCount();
        assertEquals(i, 10);
    }
}