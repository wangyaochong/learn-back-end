package com.wangyaochong.common;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangyaochong
 * date 2020/5/2 13:34
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountLoginControllerTest {

    AccountDao accountDao;
    HttpServletRequest request;
    AccountLoginController accountLoginController;

    @Before
    public void setUp() {
        this.accountDao = Mockito.mock(AccountDao.class);
        this.request = Mockito.mock(HttpServletRequest.class);
        this.accountLoginController = new AccountLoginController(accountDao);
    }

    @Test
    public void testLoginSuccess() {
        Account account = new Account();
        Mockito.when(request.getParameter("username")).thenReturn("alex");
        Mockito.when(request.getParameter("password")).thenReturn("123456");
        Mockito.when(accountDao.findAccount(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(account);
        String login = accountLoginController.login(request);
        Assert.assertThat(login, CoreMatchers.equalTo("/index"));
    }

    @Test
    public void testLoginFail() {
        Mockito.when(request.getParameter("username")).thenReturn("alex");
        Mockito.when(request.getParameter("password")).thenReturn("123456");
        Mockito.when(accountDao.findAccount(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(null);
        String login = accountLoginController.login(request);
        Assert.assertThat(login, CoreMatchers.equalTo("/login"));
    }

    @Test
    public void testDbError() {
        Mockito.when(request.getParameter("username")).thenReturn("alex");
        Mockito.when(request.getParameter("password")).thenReturn("123456");
        Mockito.when(accountDao.findAccount(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenThrow(UnsupportedOperationException.class);
        String login = accountLoginController.login(request);
        Assert.assertThat(login, CoreMatchers.equalTo("/505"));
    }

}
