package com.example.learnmybatis.config.readWriteAnnotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Order(0)
@Component
public class ReadOnlyConnectionInterceptor {


    @Around("@annotation(readOnlyConnection)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint, ReadOnlyConnection readOnlyConnection) throws Throwable {

        try {
            log.info("---------------set database connection 2 read only---------------");
            DataBaseContextHolder.setDataBaseType(DataBaseContextHolder.DataBaseType.SLAVE);
            Object result = proceedingJoinPoint.proceed();
            return result;
        } finally {
            DataBaseContextHolder.clearDataBaseType();
            log.info("---------------clear database connection---------------");
        }
    }

}
