package com.example.mockitopower.service;

import com.example.mockitopower.common.User;
import com.example.mockitopower.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserDao.class,UserServiceVerify.class})
public class UserServiceVerifyTest {

    @Test
    public void whenInsert() throws Exception {
        UserServiceVerify userServiceVerify = new UserServiceVerify();
        User user = new User();
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
        PowerMockito.when(userDao.getCount()).thenReturn(0);
        userServiceVerify.saveOrUpdate(user);
        Mockito.verify(userDao).insertUser(user);
        Mockito.verify(userDao,Mockito.never()).updateUser(user);
    }
}