package leetcode.byNumber;

import org.junit.Test;

public class p29_Divide {
    public int divide(int dividend, int divisor) {
        long res = div(dividend, divisor);
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) res;
    }

    public long div(long dividend, long divisor) {
        //先调整符号
        if (dividend > 0 && divisor < 0) {
            return -div(dividend, -divisor);
        }
        if (dividend < 0 && divisor < 0) {
            return div(-dividend, -divisor);
        }
        if (dividend < 0 && divisor > 0) {
            return -div(-dividend, divisor);

        }

        if (dividend < divisor) {
            return 0;
        }

        int count = 1;
        long temp = divisor;
        while (dividend > temp + temp) {
            count = count + count;
            temp = temp + temp;
        }
        return count + div(dividend - temp, divisor);
    }

    @Test
    public void test() {
        System.out.println(divide(-1, -1));
        System.out.println(divide(7, -1));
        System.out.println(divide(7, 3));
        System.out.println(divide(2147483647, 1));
        System.out.println(divide(-2147483648, 1));
    }
}
