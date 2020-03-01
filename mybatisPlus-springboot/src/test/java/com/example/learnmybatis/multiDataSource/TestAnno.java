package com.example.learnmybatis.multiDataSource;

import com.example.learnmybatis.BaseTest;
import com.example.learnmybatis.entity.User;
import com.example.learnmybatis.mapper.zReadWriteAnnotationMapper.UserMapperAnno;
import com.example.learnmybatis.service.IUserServiceForReadWrite;
import org.junit.Test;

import javax.annotation.Resource;

public class TestAnno extends BaseTest {

    @Resource
    UserMapperAnno userMapperAnno;
    @Resource
    IUserServiceForReadWrite userServiceForReadWrite;

    @Test
    public void test() {
        User user = userMapperAnno.selectById(1);
        user.setAge(6000);
        userServiceForReadWrite.annoUpdateUser(user);
    }


    @Test
    public void testSelect() {
        /**
         * 通过给selectById加注解判断是否读写分离配置有效
         */
        System.out.println(userServiceForReadWrite.selectById(1));
    }
}
