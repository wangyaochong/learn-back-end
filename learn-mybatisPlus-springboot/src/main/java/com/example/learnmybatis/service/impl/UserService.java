package com.example.learnmybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.learnmybatis.entity.User;
import com.example.learnmybatis.mapper.other.UserMapperPlus;
import org.springframework.stereotype.Service;


@Service
public class UserService extends ServiceImpl<UserMapperPlus, User> {


}
