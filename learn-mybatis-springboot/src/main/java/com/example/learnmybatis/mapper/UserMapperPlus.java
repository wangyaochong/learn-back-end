package com.example.learnmybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.learnmybatis.entity.User;

import java.util.List;

public interface UserMapperPlus extends BaseMapper<User> {

    List<User> findByAge(Integer age);

}
