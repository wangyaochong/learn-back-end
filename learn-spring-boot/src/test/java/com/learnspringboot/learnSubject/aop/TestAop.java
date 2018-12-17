package com.learnspringboot.learnSubject.aop;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import util.UtilLog;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestAop {
    @Resource
    Base base;


    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        Field field = System.class.getDeclaredField("props");
        field.setAccessible(true);
        Properties props = (Properties) field.get(null);
        props.put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        String s = base.methodAop("测试");
        base.methodAopVoid("测试无返回值");
        String s1 = base.myTransaction();
        log.info(UtilLog.prefixLog("result={}"),s);
    }

    @Test
    public void testOuterInner() {
        base.outerMethod("你好");
//        base.innerMethod("你好");
    }
}
