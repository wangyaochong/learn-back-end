package com.learnmybatisspringboot.generated.controller;

import com.learnmybatisspringboot.generated.entity.Account;
import com.learnmybatisspringboot.generated.service.AccountService;
import com.learnmybatisspringboot.service.TestPropagationMain;
import org.springframework.aop.framework.AopContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 账户表(Account)表控制层
 *
 * @author makejava
 * @since 2020-03-23 10:53:27
 */
@RestController
@RequestMapping("account")
public class AccountController {
    /**
     * 服务对象
     */
    @Resource
    private AccountService accountService;

    @Resource
    TestPropagationMain main;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Account selectOne(Long id) {
        return this.accountService.queryById(id);
    }

    @GetMapping("testRollBack")
    @Transactional(rollbackFor = Exception.class)
    public void testRollBack() {
        Account account = accountService.queryById(1L);
        System.out.println(account);
        accountService.insert(new Account(null, "test3", 18.0));
        int i = 1;
        if (i == 1) {
            throw new RuntimeException("sdfsd");
        }
        accountService.insert(new Account(null, "test4", 18.0));
    }

    @Resource
    DataSourceTransactionManager transactionManager;

    public void testx() {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = transactionManager.getTransaction(def);
        transactionManager.commit(transactionStatus);
    }

    @GetMapping("testPropagation")
    public void testPropagation() {
        //测试required_new，会发现main回滚了，而sub没有回滚
        main.mainInsert();
    }

    //    嵌套调用使用同一个事务

    @GetMapping("testPropagationSameClass")
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void testPropagationSameClass() {
        mainError();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void mainError() {
        accountService.insert(new Account(null, "testPropagationMain", 18.0));
        sub();
        throw new RuntimeException("main");
    }

    @GetMapping("testMain")
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void main() {
        accountService.insert(new Account(null, "testPropagationMain", 18.0));
        ((AccountController) (AopContext.currentProxy())).sub();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void sub() {
        accountService.insert(new Account(null, "testPropagationSub", 18.0));
    }

    @GetMapping("testRequiredNew")
    public void testRequiredNew() {
    }

    //    可以暴露当前的代理对象

    @GetMapping("testPropagationSameClassProxy")
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void testPropagationSameClassProxy() {
        ((AccountController) (AopContext.currentProxy())).mainProxy();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void mainProxy() {
        accountService.insert(new Account(null, "testPropagationMain", 18.0));
        ((AccountController) (AopContext.currentProxy())).subProxy();
        throw new RuntimeException("mainProxy");
    }

    @GetMapping("subProxy")
    public void subProxyCall() {
        ((AccountController) (AopContext.currentProxy())).subProxy();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void subProxy() {
        accountService.insert(new Account(null, "testPropagationSub", 18.0));
    }
}