package com.example.shiro.test;

import com.example.shiro.realm.CustomerRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

class TestCustomerRealm {
    public static void main(String[] args) {
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(new CustomerRealm());
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("xiaochen", "123");

        try {
            System.out.println("登录前，认证状态=" + subject.isAuthenticated());
            subject.login(token);
            System.out.println("登录成功，认证状态=" + subject.isAuthenticated());
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误");
        }

        if (subject.isAuthenticated()) {
            System.out.println("是否有admin权限=" + subject.hasRole("admin"));//基于角色
            System.out.println("用户权限user:*:*=" + subject.isPermitted("user:*:*"));
            System.out.println("用户权限user:*:01=" + subject.isPermitted("user:*:01"));
            System.out.println("用户权限user:update:01=" + subject.isPermitted("user:update:01"));
            System.out.println("同时具有权限="+subject.isPermittedAll("user:*:01","product:create:01"));
        } else {
            System.out.println("用户没有登录");
        }
    }
}