package leetcode;

import org.junit.Test;

public class p69_Sqrtx_牛顿迭代法 {
    public int mySqrt(int x) {
        //使用牛顿迭代法求解，即  y=x^2-a,   y'=2x  求得x=(x+a/x)/2;


        long a = x;
        while (a * a > x) {
            a = (a + x / a) / 2;
        }
        return (int) a;
    }

    @Test
    public void test() {
        System.out.println(mySqrt(2147395599));
    }
}
