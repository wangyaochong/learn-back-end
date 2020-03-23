package com.wangyaochong.springsecurityboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangyaochong
 * @date 2020/3/23 15:01
 */
@RestController
public class TestController {

    @RequestMapping("success")
    @ResponseBody
    public String success() {
        return "success";
    }

    @GetMapping("test")
    public String test() {
        return "test";
    }

    @GetMapping("r1")
    public String r1() {
        return "r1";
    }

    @GetMapping("r2")
    public String r2() {
        return "r2";
    }

    @GetMapping("authTest")
    public String authTest() {
        return "authTest";
    }


}
