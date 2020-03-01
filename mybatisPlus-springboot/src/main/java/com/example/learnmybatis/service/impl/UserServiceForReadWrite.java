package com.example.learnmybatis.service.impl;

import com.example.learnmybatis.config.readWriteAnnotation.ReadOnlyConnection;
import com.example.learnmybatis.entity.User;
import com.example.learnmybatis.mapper.read.UserMapperRead;
import com.example.learnmybatis.mapper.write.UserMapper;
import com.example.learnmybatis.mapper.zReadWriteAnnotationMapper.UserMapperAnno;
import com.example.learnmybatis.service.IUserServiceForReadWrite;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceForReadWrite implements IUserServiceForReadWrite {
    @Resource
    UserMapper userMapper;
    @Resource
    UserMapperRead userMapperRead;
    @Resource
    UserMapperAnno userMapperAnno;

    @Transactional
    @Override
    public void writeUpdateUserMultiMapper(User user) {
        userMapper.updateUserById(user);
        throw new RuntimeException("测试事务");
    }

    @Transactional
    @Override
    public void readUpdateUserMultiMapper(User user) {
        userMapperRead.updateUserById(user);
        throw new RuntimeException("测试事务");
    }

    @ReadOnlyConnection
    @Transactional
    @Override
    public void annoUpdateUser(User user) {
        userMapperAnno.updateUserById(user);
        throw new RuntimeException("测试事务");
    }

    @Override
//    @ReadOnlyConnection
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

}
