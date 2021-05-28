package com.wangyaochong;

import com.wangyaochong.ioc.WApplicationContext;
import org.junit.Test;

/**
 * @author wangyaochong
 * @date 2020/3/25 21:26
 */
public class MyTest {
    public static void testDotMethod(Integer... params) {
        int length = params.length;
        for (Integer param : params) {
            System.out.println(param);
        }
        for (int i = 0 ; i < length ; i++) {
            System.out.println(params[i]);
        }
    }

    public static void main(String[] args) {
        Thread.interrupted();
        testDotMethod(1, 2, 3, 34);

    }
    
    @Test
    public void test(){

        WApplicationContext applicationContext = new WApplicationContext();
    }
}
