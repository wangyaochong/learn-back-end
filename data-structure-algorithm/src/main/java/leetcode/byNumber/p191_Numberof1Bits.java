package leetcode.byNumber;

import org.junit.Test;

public class p191_Numberof1Bits {

    public int hammingWeight(int n) {
        int count = 0;
        int i = 0;
        while (i < 32) {
            count += n & 1;
            n >>>= 1;
            i++;
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(hammingWeight(11));
    }

}
