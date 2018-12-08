package leetcode.byNumber;

import org.junit.Test;

public class p190_ReverseBits {
    public int reverseBits(int n) {
        int sum = 0;
        int count = 0;
        while (count < 32) {
            sum += n & 1;
            n >>>= 1;
            if (count < 31) {
                sum <<= 1;
            }
            count++;
        }
        return sum;
    }

    @Test
    public void test() {
        System.out.println(1 | 0xF0000000);
    }
}
