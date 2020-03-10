package leetcode.byNumber;

import org.junit.Test;

public class p279_PerfectSquares_dp更快一点 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int j;
        int tmp;
        for (int i = 1; i <= n; ++i) {
            dp[i] = Integer.MAX_VALUE;
            j = 1;
            tmp = j * j;
            while (i - tmp >= 0) {
                dp[i] = Math.min(dp[i], dp[i - tmp] + 1);
                j++;
                tmp = j * j;
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
