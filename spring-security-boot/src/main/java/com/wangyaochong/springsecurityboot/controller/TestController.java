package com.wangyaochong.springsecurityboot.controller;

import com.wangyaochong.springsecurityboot.util.UtilSecurity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangyaochong
 * @date 2020/3/23 15:01
 */
@RestController
@Slf4j
public class TestController {

    @RequestMapping("success")
    @ResponseBody
    public String success() {
        log.info(UtilSecurity.getUserName() + " 登录成功");
        return "success";
    }

    @GetMapping("test")
    public String test() {
        return "test";
    }

    @GetMapping("r1")
    @PreAuthorize("hasAuthority('p1')")
    public String r1() {
        return "r1";
    }

    @GetMapping("r2")
    @PreAuthorize("hasAuthority('p2')")
    public String r2() {
        return "r2";
    }

    @GetMapping("authTest")
    public String authTest() {
        return "authTest";
    }


}
