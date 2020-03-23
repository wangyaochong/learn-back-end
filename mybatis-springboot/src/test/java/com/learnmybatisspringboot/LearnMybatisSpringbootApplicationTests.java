package com.learnmybatisspringboot;

import com.learnmybatisspringboot.generated.entity.Account;
import com.learnmybatisspringboot.generated.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(value = false)
public class LearnMybatisSpringbootApplicationTests {

    @Test
    public void contextLoads() {

    }

    @Resource
    AccountService accountService;

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void test() {
        Account account = accountService.queryById(1L);
        System.out.println(account);
        accountService.insert(new Account(null, "test3", 18.0));
        int i = 1;
        if (i == 1) {
            throw new RuntimeException("sdfsd");
        }
        accountService.insert(new Account(null, "test4", 18.0));

    }

    @Test
    public void test2() {

    }

}
