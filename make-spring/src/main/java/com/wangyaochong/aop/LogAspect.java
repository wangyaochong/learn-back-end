package com.wangyaochong.aop;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Date;

/**
 * @author wangyaochong
 * @date 2020/3/27 11:07
 */
@Slf4j
public class LogAspect {
    public void before(WJointPoint jointPoint){
        log.info("before method => " +jointPoint.getMethod());
    }

    public void after(WJointPoint jointPoint) {
        log.info("after method => "+jointPoint.getMethod());
    }
    public void afterThrowing(WJointPoint jointPoint,Throwable ex){
        log.info("出现异常 method=> "+jointPoint.getMethod()+", exception="+ Arrays.toString(ex.getStackTrace()));
    }

}
