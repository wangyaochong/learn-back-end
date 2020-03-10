package leetcode.byNumber;


import org.junit.Test;

public class p172_FactorialTrailingZeroes_逻辑好题 {
    public int trailingZeroes(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n / 5;
            n /= 5;
        }
        return sum;
    }

    @Test
    public void test() {
        System.out.println(trailingZeroes(5));
    }
}
