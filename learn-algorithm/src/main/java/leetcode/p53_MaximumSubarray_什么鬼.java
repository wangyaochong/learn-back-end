package leetcode;

import org.junit.Test;

public class p53_MaximumSubarray_什么鬼 {
    public int maxSubArray(int[] nums) {
        int curSum = nums[0];
        int max = curSum;
        for (int i = 1; i < nums.length; i++) {
            curSum = curSum + nums[i] > nums[i] ? curSum + nums[i] : nums[i];
            if (max < curSum) {
                max = curSum;
            }
        }
        return max;
    }

    @Test
    public void test() {
        System.out.println(maxSubArray(new int[]{1, 2, -2, 1}));
    }
}
