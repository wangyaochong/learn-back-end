package com.learnspringboot.basePackage.controller;

import com.learnspringboot.basePackage.service.UserService;
import entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
}
