package com.learnmybatisspringboot.service;

import com.learnmybatisspringboot.generated.entity.Account;
import com.learnmybatisspringboot.generated.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wangyaochong
 * @date 2020/3/23 12:52
 */
@Service
public class TestPropagationMain {
    @Resource
    AccountService accountService;

    @Resource
    TestPropagationSub sub;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void mainInsert() {
        accountService.insert(new Account(null, "testPropagationMain", 18.0));
        sub.subInsert();
        throw new RuntimeException("testPropagationMain");
    }
}
