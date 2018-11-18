package com.example.learnmybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.learnmybatis.entity.User;
import com.example.learnmybatis.mapper.KDataBackTestMapper;
import com.example.learnmybatis.mapper.UserMapperPlus;
import com.example.learnmybatis.mapper.UserMapperWithAnno;
import com.example.learnmybatis.mapper.UserMapperWithXml;
import com.example.learnmybatis.service.UserService;
import com.example.learnmybatis.util.WrapperFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnMybatisApplicationTests {

    @Resource
    UserMapperWithXml userMapperWithXml;
    @Resource
    UserMapperWithAnno userMapperWithAnno;
    //	@Resource
    //	UserMapperGeneric userMapperGeneric;
    @Resource
    KDataBackTestMapper kDataBackTestMapper;
    @Resource
    private UserMapperPlus userMapperPlus;
    @Resource
    private UserService userService;


//    @Resource
//    private GenericService genericService;


    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        //		System.out.println(userMapperWithXml.selectAllUser());
        //		System.out.println(userMapperWithAnno.selectAllUser());
        //		System.out.println(userMapperGeneric.selectAll());
        //		Example example=new Example(User.class);
        //		Example.Criteria criteria = example.createCriteria();
        //		criteria.andCondition("id=1");
        //		System.out.println(userMapperGeneric.selectByExample(example));

        PageInfo<User> objectPageInfo =
                PageHelper.startPage(1, 2).doSelectPageInfo(() -> userService.list(null));
        System.out.println(objectPageInfo);

        System.out.println(userService.list(null));

        System.out.println(userMapperPlus.findByAge(1));


        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.and(w -> w.eq("age", "2").eq("name", "2").and(x -> x.eq("id", "1"))).or(w -> w.eq("id", "3"));
        System.out.println(userQueryWrapper.getSqlSelect());
        System.out.println(userService.list(userQueryWrapper));


        System.out.println(userService.list(WrapperFactory.<User>getQueryWrapper().ge("age", "1").le("age", "2")));

        WrapperFactory<User> wrapperFactory = WrapperFactory.getWrapperFactory();
        System.out.println(wrapperFactory.queryWrapper().eq("age", "1"));
        System.out.println(userService.list(wrapperFactory.queryWrapper().eq("age", "1")));


        System.out.println(kDataBackTestMapper.selectList(null));
//        KDataBackTest build = new KDataBackTest();
//        build.setAmount(1d);
//        build.setCode("1223");
//        build.setDate("2018-01-01");
//        int insert = kDataBackTestMapper.insert(build);
//        System.out.println(build);
    }

}
