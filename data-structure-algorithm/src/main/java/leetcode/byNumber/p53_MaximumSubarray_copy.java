package leetcode.byNumber;

import org.junit.Test;

public class p53_MaximumSubarray_copy {
    public int maxSubArray(int[] nums) {

        int totalMax = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < currentMax + nums[i]) {
                currentMax = currentMax + nums[i];
            } else {
                currentMax = nums[i];
            }
            if (totalMax < currentMax) {
                totalMax = currentMax;
            }
        }
        return totalMax;
    }

    @Test
    public void test() {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
