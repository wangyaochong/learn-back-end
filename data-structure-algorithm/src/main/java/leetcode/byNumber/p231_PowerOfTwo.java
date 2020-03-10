package leetcode.byNumber;

import org.junit.Test;

public class p231_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 8 || n == 4 || n == 2 || n == 1) {
            return true;
        }
        if (n % 2 == 1) {
            return false;
        } else {
            return isPowerOfTwo(n / 2);
        }
    }

    @Test
    public void test() {
        System.out.println(isPowerOfTwo(218));
        System.out.println(isPowerOfTwo(8));
        System.out.println(isPowerOfTwo(21));
    }
}
