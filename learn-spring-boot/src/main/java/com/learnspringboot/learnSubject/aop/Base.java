package com.learnspringboot.learnSubject.aop;

import com.learnspringboot.learnSubject.aop.annotation.MyTransaction;
import com.learnspringboot.learnSubject.aop.interfaces.IBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import util.UtilLog;

@Component
@Slf4j
public class Base implements IBase{
    @Override
    public String methodAop(String param){
        log.info(UtilLog.prefixLog("method is executed, param={}"),param);
        return "method finished!";
    }

    @Override
    public void methodAopVoid(String param) {
        log.info(UtilLog.prefixLog("methodAopVoid is executed, param={}"),param);
    }


    @MyTransaction(value = "test")
    @Override
    public String myTransaction() {
        return "method used aop transaction";
    }



}
