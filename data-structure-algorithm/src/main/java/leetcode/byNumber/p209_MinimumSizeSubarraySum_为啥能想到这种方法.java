package leetcode.byNumber;

import org.junit.Test;

public class p209_MinimumSizeSubarraySum_为啥能想到这种方法 {
    public int minSubArrayLen(int s, int[] nums) {
        if (s == 0 || nums.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            end++;
            while (sum >= s) {
                min = Math.min(min, end - start);
                sum -= nums[start];
                start++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


    @Test
    public void test() {
        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }
}
