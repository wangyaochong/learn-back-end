package com.example.learnmybatis.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.learnmybatis.entity.User;
import com.example.learnmybatis.mapper.GenericMapper;
import org.springframework.stereotype.Service;

@Service
public class GenericService extends ServiceImpl<GenericMapper, User> {
}
