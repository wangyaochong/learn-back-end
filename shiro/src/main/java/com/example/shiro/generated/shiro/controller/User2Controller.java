package com.example.shiro.generated.shiro.controller;


import com.example.shiro.generated.shiro.entity.User;
import com.example.shiro.generated.shiro.service.UserRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mybatis-plus generated
 * @since 2021-07-13
 */
@RestController
@RequestMapping("/user2")
public class User2Controller {
    @Resource UserRepo userRepo;

    @GetMapping("/getAll")
    public String getAll(){
        List<User> list = userRepo.list(null);
        return "ok";
    }

}
