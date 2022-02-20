package com.example.redisspringboot;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestOom {
    @Test
    public void testOom() throws InterruptedException {
        List<Long[]> list = new ArrayList<>();
        System.out.println("开始");
        try {
//            throw new OutOfMemoryError("sdfsd");
            while (true) {
                list.add(new Long[1000000]);
            }
        } catch (Throwable e) {
            System.out.println("---出现异常---");
            e.printStackTrace();
        } finally {
            System.out.println("---执行finally---");
            list.add(new Long[1000000]);
            System.out.println("---执行finally结束---");
        }
        System.out.println("运行结束");
        Thread.sleep(1000000);
    }
}
