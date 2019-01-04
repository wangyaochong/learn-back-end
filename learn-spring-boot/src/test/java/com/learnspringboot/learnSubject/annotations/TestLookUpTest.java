package com.learnspringboot.learnSubject.annotations;

import com.learnspringboot.BaseTest;
import com.learnspringboot.learnSubject.annotations.lookup.ClassA;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

public class TestLookUpTest extends BaseTest {

    @Resource
    ClassA classA;

    @Test
    public void test() throws InterruptedException {
        classA.display();
        TimeUnit.SECONDS.sleep(1);
        classA.display();
        TimeUnit.SECONDS.sleep(1);
        classA.display();
    }
}