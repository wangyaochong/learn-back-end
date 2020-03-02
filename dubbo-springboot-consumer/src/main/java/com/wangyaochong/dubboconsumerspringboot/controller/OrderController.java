package com.wangyaochong.dubboconsumerspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wangyaochong.bean.UserAddress;
import wangyaochong.service.OrderService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class OrderController {
    @Resource
    OrderService orderService;

    @RequestMapping("initOrder")
    @ResponseBody
    public List<UserAddress> initOrder(@RequestParam(name = "userId") String userId) {
        return orderService.initOrder(userId);
    }
}
