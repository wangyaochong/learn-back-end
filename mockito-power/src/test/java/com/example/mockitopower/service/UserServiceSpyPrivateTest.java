package com.example.mockitopower.service;

import com.example.mockitopower.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@PowerMockRunnerDelegate()//可以使用多个runner
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserServiceNoInit.class)
public class UserServiceSpyPrivateTest {

    @Test
    public void testMockLog() throws Exception {
        //UserDao userDao = PowerMockito.mock(UserDao.class);
        //PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
        UserServiceNoInit userService = PowerMockito.mock(UserServiceNoInit.class);
        userService.log("abc");
    }

    @Test
    public void testSpyLog() throws Exception {
        // UserDao userDao = PowerMockito.spy(new UserDao());
        //PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
        UserServiceNoInit userService = PowerMockito.spy(new UserServiceNoInit());
        userService.log("abc");

        PowerMockito.doNothing().when(userService).log("xxx");//可以录制行为
        userService.log("xxx");

        userService.log("yyy");
    }

    @Test
    public void testCheck() throws Exception {
        UserServiceNoInit userService = PowerMockito.spy(new UserServiceNoInit());
        PowerMockito.doReturn(true).when(userService, "checkExist", "alex");//调用私有方法
        assertTrue(userService.exist("alex"));
        System.out.println("第一次spy执行成功");

        userService.exist("other");//调用实际方法失败
    }
}
