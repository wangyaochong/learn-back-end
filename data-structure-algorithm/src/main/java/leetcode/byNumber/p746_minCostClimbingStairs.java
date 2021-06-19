package leetcode.byNumber;

import org.junit.Test;

public class p746_minCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length + 1];
        for (int i = 0; i < cost.length; i++) {
            dp[i] = cost[i];
        }
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + dp[i];
        }
        return dp[cost.length];
    }

    @Test
    public void test() {
        int i1 = minCostClimbingStairs(new int[]{10, 15, 20});
        int i2 = minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        System.out.println(i1);
        System.out.println(i2);

    }
}
