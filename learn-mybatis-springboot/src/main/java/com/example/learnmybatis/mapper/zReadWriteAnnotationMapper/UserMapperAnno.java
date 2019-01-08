package com.example.learnmybatis.mapper.zReadWriteAnnotationMapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.learnmybatis.entity.User;

import java.util.List;

public interface UserMapperAnno extends BaseMapper<User> {

    User selectUserById(Integer integer);

    List<User> selectAllUser();

    void updateUserById(User user);
}
