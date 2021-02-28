package leetcode.byNumber;

import org.junit.Test;

public class p69_Sqrtx_牛顿迭代法 {
    public int mySqrt(int A) {
        //使用牛顿迭代法求解，即  y=x^2-a,曲线的切线为斜率为2x
        // y'=2x  求得x=(x+a/x)/2;
        if(A==0){
            return 0;
        }
        long x = A;
        while (x > (A / x)) {
            x = (x + A / x) / 2;
        }
        return (int) x;
    }

    public int mySqrt2(int x) {
        int l = 0;
        int r = x;
        while (l < r) {
            int mid = (int) (((long) l + r + 1) / 2); //相加有溢出风险，使用Long
            if (mid <= x / mid) l = mid; //这一行相乘有溢出风险，所以使用除法
            else r = mid - 1;
        }
        return l;
    }

    @Test
    public void test() {
        System.out.println(mySqrt(2147483647));
//        System.out.println(mySqrt2(2147395599));
    }
}
