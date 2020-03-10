package leetcode.byNumber;

import org.junit.Test;

public class p279_PerfectSquares_dp {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) {
                dp[i] = 1;
            } else {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 1; j <= sqrt; j++) {
                    int tmp = j * j;
                    int count = dp[i - tmp] + dp[tmp];
                    if (dp[i] > count) {
                        dp[i] = count;
                    }
                }
            }
        }
        return dp[n];
    }


    @Test
    public void test() {
        int i = numSquares(12);
        System.out.println(i);
    }
}
