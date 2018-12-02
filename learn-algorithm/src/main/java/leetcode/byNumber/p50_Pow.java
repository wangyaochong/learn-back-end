package leetcode.byNumber;

import org.junit.Test;

public class p50_Pow {
    public double myPow(double x, int n) {
        int sign = 1;
        long nL = n;
        if (n < 0) {
            sign = -1;
            nL = -nL;
        }
        double v = positivePow(x, nL);
        if (sign == -1) {
            return 1 / v;
        }
        return v;
    }

    public double positivePow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double result = positivePow(x, n / 2);
        if (n % 2 == 1) {
            return result * result * x;
        } else {
            return result * result;
        }
    }

    @Test
    public void test() {
        System.out.println(myPow(2, -2147483648));
    }
}
