package com.learnspringboot.learnSubject.aop;

import com.learnspringboot.learnSubject.aop.annotation.MyTransaction;
import com.learnspringboot.learnSubject.aop.interfaces.IBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import util.UtilLog;

@Component
@Slf4j
public class Base implements IBase, ApplicationContextAware {
    ApplicationContext applicationContext;

    @Override
    public String methodAop(String param) {
        log.info(UtilLog.prefixLog("method is executed, param={}"), param);
        return "method finished!";
    }

    @Override
    public void methodAopVoid(String param) {
        log.info(UtilLog.prefixLog("methodAopVoid is executed, param={}"), param);
    }


    @MyTransaction(value = "test")
    @Override
    public String myTransaction() {
        return "method used aop transaction";
    }

    @Override
    public String outerMethod(String param) {
        log.info("outerMethod executed");
        log.info(innerMethod("inner method after outer method --- no proxy method"));//这种写法代理方法肯定不执行
        IBase bean = applicationContext.getBean(IBase.class);
        log.info(bean.innerMethod("inner method after outer method --- has proxy method"));//这种写法代理方法肯定会执行
        log.info(((IBase) AopContext.currentProxy()).innerMethod("inner method after outer method --- exposeProxy=true --- has proxy method"));//这种写法当exposeProxy等于false时会抛IllegalStateException
        return "outerMethod return value:" + param;
    }

    @Override
    public String innerMethod(String param) {
        log.info("innerMethod executed");
        return "innerMethod return value:" + param;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public String methodAopForNoExecute(String param) {
        log.info("methodAopForNoExecute，param={}", param);
        return "methodAopForNoExecute";
    }
}
