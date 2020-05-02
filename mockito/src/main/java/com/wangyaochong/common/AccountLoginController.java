package com.wangyaochong.common;

import javax.servlet.http.HttpServletRequest;

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
            return "/505";
        }
    }
}
