package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;

public class p213_HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length + 2];
        for (int i = 1; i < nums.length; i++) {//强制不偷第一个
            dp[i + 2] = Math.max(dp[i] + nums[i], dp[i + 1]);
        }
        int max = dp[nums.length + 1];
        Arrays.fill(dp, 0);
        for (int i = nums.length; i >= 2; i--) {//强制不偷最后一个
            dp[i - 2] = Math.max(dp[i] + nums[i - 2], dp[i - 1]);
        }
        //如果简单的两边扫描，有可能首尾相连，所以需要强制指定
        return Math.max(max, dp[0]);
    }

    @Test
    public void test() {
        System.out.println(rob(new int[]{1}));
    }
}
