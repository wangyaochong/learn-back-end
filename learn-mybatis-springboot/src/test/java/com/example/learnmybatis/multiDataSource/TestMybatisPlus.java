package com.example.learnmybatis.multiDataSource;

import com.example.learnmybatis.BaseTest;
import com.example.learnmybatis.mapper.read.UserMapperRead;
import com.example.learnmybatis.mapper.write.UserMapper;
import org.junit.Test;

import javax.annotation.Resource;

public class TestMybatisPlus extends BaseTest {
    @Resource
    UserMapper userMapper;
    @Resource
    UserMapperRead userMapperRead;

    @Test
    public void test() {
        /**
         * 对于使用mybatis-plus的配置，只对单个数据源生效
         */
        System.out.println(userMapper.selectById(1));
        System.out.println(userMapper.selectUserById(1));
        System.out.println(userMapperRead.selectUserById(1));
    }
}
