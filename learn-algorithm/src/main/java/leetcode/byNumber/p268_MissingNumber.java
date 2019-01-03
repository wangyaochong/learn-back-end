package leetcode.byNumber;

import org.junit.Test;

public class p268_MissingNumber {

    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = len * (len + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    @Test
    public void test() {
        System.out.println(missingNumber(new int[]{3, 0, 1}));
    }
}
