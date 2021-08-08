package com.example.mockitopower.service;

import com.example.mockitopower.dao.UserDao;
import com.example.mockitopower.dao.UserDaoInitParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserServiceInitParam.class)
public class UserServiceInitParamTest {

    @Test
    public void save() throws Exception {
        UserDaoInitParam userDao = PowerMockito.mock(UserDaoInitParam.class);
        String username = "xxx";
        String password = "pass";

        PowerMockito.whenNew(UserDaoInitParam.class)
                .withArguments(username, password).thenReturn(userDao);

        PowerMockito.doNothing().when(userDao).save();

        UserServiceInitParam userService = new UserServiceInitParam();
        userService.save(username, password);

        Mockito.verify(userDao).save();
    }
}