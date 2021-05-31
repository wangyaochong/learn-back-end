package com.wangyaochong.common;

import com.github.javafaker.Faker;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * @author wangyaochong
 * date 2020/5/2 13:28
 */
public class AccountLoginController {

    private AccountDao accountDao = null;

    public AccountLoginController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public String login(HttpServletRequest request) {

        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Account account = accountDao.findAccount(username, password);
            if (account == null) {
                return "/login";
            } else {
                return "/index";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "/505";
        }
    }
}
