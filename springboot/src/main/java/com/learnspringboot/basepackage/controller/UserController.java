package com.learnspringboot.basepackage.controller;

import com.learnspringboot.basepackage.service.UserService;
import entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* @author wangyaochong
* @date 2021/6/2
*/

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/getByName")
    public User getByName(String name) {
        log.info("controller 层根据name获取用户，name={}", name);
        return userService.getUserByName(name);
    }

    @PostMapping("/updateUser")
    public void updateUser() {
        userService.updateUser();
    }
}
