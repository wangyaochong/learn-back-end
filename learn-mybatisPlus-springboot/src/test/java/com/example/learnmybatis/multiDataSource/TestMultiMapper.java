package com.example.learnmybatis.multiDataSource;

import com.example.learnmybatis.BaseTest;
import com.example.learnmybatis.entity.User;
import com.example.learnmybatis.mapper.other.UserMapperWithXml;
import com.example.learnmybatis.mapper.read.UserMapperRead;
import com.example.learnmybatis.mapper.write.UserMapper;
import com.example.learnmybatis.service.IUserServiceForReadWrite;
import org.junit.Test;

import javax.annotation.Resource;

public class TestMultiMapper extends BaseTest {
    @Resource
    UserMapper userMapper;
    @Resource
    UserMapperRead userMapperRead;
    @Resource
    UserMapperWithXml userMapperWithXml;
    @Resource
    IUserServiceForReadWrite userServiceForReadWrite;


    @Test
    public void test() {
        System.out.println(userMapper.selectAllUser());
        System.out.println(userMapperRead.selectAllUser());
        System.out.println(userMapperWithXml.selectAllUser());
    }

    /**
     * 在使用多mapper类型的多数据源时，mybatis-plus配置不生效
     */
    @Test
    public void testWriteTransaction() {
        User user = userMapper.selectUserById(1);
        user.setAge(2000);
        //spring的transactionManager会注入一个dataSource，本例子中使用了@Primary给write数据源，所以write数据源事务生效
        userServiceForReadWrite.writeUpdateUserMultiMapper(user);
    }

    @Test
    public void testReadTransaction() {
        User user = userMapper.selectUserById(1);
        user.setAge(2000);
        userServiceForReadWrite.readUpdateUserMultiMapper(user);//对于read数据源，是没有被spring事务管理的
    }
}
