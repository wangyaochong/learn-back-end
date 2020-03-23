package com.wangyaochong.springsecurityboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wangyaochong
 * @date 2020/3/23 16:31
 */
@Controller
public class ViewController {

    @RequestMapping("/login-fail")
    public String loginFail() {
        return "fail";
    }
}
