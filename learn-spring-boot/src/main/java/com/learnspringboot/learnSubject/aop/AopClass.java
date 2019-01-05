package com.learnspringboot.learnSubject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import util.UtilLog;

import javax.annotation.Resource;

@Aspect
@Slf4j
@Component
public class AopClass {

    @Resource
    DataSourceTransactionManager dataSourceTransactionManager;

    @Pointcut("execution(* *Aop(String))")
    public void pointCut(){}

    @Before("pointCut()")
    public void beforeLog(){
        log.info(UtilLog.prefixLog("before log"));
    }

    @After("pointCut()")
    public void afterLog(){
        log.info(UtilLog.prefixLog("after log"));
    }

    @AfterReturning("pointCut()")
    public void afterReturnLog(){
        log.info(UtilLog.prefixLog("after return log"));
    }

    @AfterReturning(pointcut = "execution(* *Aop(String))", returning = "retValue")
    public void afterReturnLogWthReturnValue(String retValue) {
        log.info("return value ={}", retValue);
        log.info(UtilLog.prefixLog("after return log"));
    }

    @After( "execution(* *Aop(String))")
    public void afterLog2(){
        log.info(UtilLog.prefixLog("after log 2"));
    }

    @After("execution(* *Aop(String))")
    public void returnLog(){
        log.info(UtilLog.prefixLog("return log"));
    }


    @Around("execution(* *Aop(String))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info(UtilLog.prefixLog("around before"));
        Object proceed = pjp.proceed();
        log.info(UtilLog.prefixLog("around after"));
        return "method return changed";
    }

    @Around("execution(* *methodAopVoid(String))")
    public Object aroundVoid(ProceedingJoinPoint pjp) throws Throwable {
        log.info(UtilLog.prefixLog("aroundVoid before"));
        Object proceed = pjp.proceed();
        log.info(UtilLog.prefixLog("aroundVoid after"));
        return "aroundVoid return changed";
    }


    @Around("@annotation(com.learnspringboot.learnSubject.aop.annotation.MyTransaction)")
    public Object aroundTransaction(ProceedingJoinPoint pjp) throws Throwable {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(def);
        log.info(UtilLog.prefixLog("开启事务"));
        try {
            Object proceed = pjp.proceed();
            log.info(UtilLog.prefixLog("数据处理完毕"));
            dataSourceTransactionManager.commit(transaction);
            log.info(UtilLog.prefixLog( "提交事务"));
            return proceed;
        }catch (Exception e){
            dataSourceTransactionManager.rollback(transaction);
            log.error("回滚事务！");
            throw new RuntimeException(e);
        }
    }


    @After("execution(* com.learnspringboot.learnSubject.aop.Base.outerMethod(..))")
    public void beforeExecuteOuterMethod() {
        log.info("outerMethod 的代理方法执行了");
    }

    @After("execution(* com.learnspringboot.learnSubject.aop.Base.innerMethod(..))")
    public void beforeExecuteInnerMethod() {
        log.info("innerMethod 的代理方法执行了");
    }


    @Around("execution(* com.learnspringboot.learnSubject.aop.Base.methodAopForNoExecute(..))")
    public Object aroundMethodAopForNoExecute(ProceedingJoinPoint pjp) throws Throwable {
        log.info(UtilLog.prefixLog("aroundVoid before"));
//        Object proceed = pjp.proceed();
        log.info(UtilLog.prefixLog("aroundVoid after"));
        return "NoExecute";
    }
}
