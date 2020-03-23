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
public class TestPropagationSub {
    @Resource
    AccountService accountService;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void subInsert() {
        accountService.insert(new Account(null, "testPropagationSub", 18.0));
    }
}
