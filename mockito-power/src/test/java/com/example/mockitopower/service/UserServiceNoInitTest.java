package com.example.mockitopower.service;

import com.example.mockitopower.common.User;
import com.example.mockitopower.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserServiceNoInit.class,UserDao.class})
public class UserServiceNoInitTest {

    @Test
    public void queryUserCount() throws Exception {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
        PowerMockito.doReturn(10).when(userDao).getCount();
        UserServiceNoInit userService = new UserServiceNoInit();
        int i = userService.queryUserCount();
        assertEquals(i, 10);
    }

    @Test
    public void saveUser() throws Exception {
        UserServiceNoInit userService = new UserServiceNoInit();
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        User user1 = new User();
        userService.saveUser(user1);
        Mockito.verify(userDao).insertUser(user1);
    }
}