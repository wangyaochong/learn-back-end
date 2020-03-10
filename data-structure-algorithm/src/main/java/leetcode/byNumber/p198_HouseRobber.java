package leetcode.byNumber;

import org.junit.Test;

public class p198_HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];

        for (int i = 0; i < nums.length; i++) {
            dp[i + 2] = Math.max(dp[i] + nums[i], dp[i + 1]);
        }
        return dp[nums.length + 1];
    }

    @Test
    public void test() {
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }

}
