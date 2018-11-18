package com.example.learnmybatis.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.learnmybatis.entity.User;
import com.example.learnmybatis.mapper.UserMapperPlus;
import org.springframework.stereotype.Service;


@Service
public class UserService extends ServiceImpl<UserMapperPlus, User> {


}
