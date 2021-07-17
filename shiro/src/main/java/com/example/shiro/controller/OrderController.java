package com.example.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/order")
public class OrderController {

    @RequiresRoles("admin")  //使用注解判断角色
    @RequiresPermissions("order:save") //需要orderSave权限
    @RequestMapping("/save")
    public String save() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.hasRole("admin")) {//使用代码方式验证权限
            System.out.println("保存订单");
        } else {
            System.out.println("无权访问");
        }
        return null;
    }
}
