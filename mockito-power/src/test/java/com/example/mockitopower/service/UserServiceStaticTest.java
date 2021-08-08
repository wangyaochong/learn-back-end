package com.example.mockitopower.service;

import com.example.mockitopower.dao.UserDaoStatic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserDaoStatic.class})
public class UserServiceStaticTest {

    @Test
    public void queryUserCount() {
        PowerMockito.mockStatic(UserDaoStatic.class);
        PowerMockito.when(UserDaoStatic.getCount()).thenReturn(10);
        int i = new UserServiceStatic().queryUserCount();
        assertEquals(i, 10);
    }

    @Test
    public void saveUser() {
    }
}