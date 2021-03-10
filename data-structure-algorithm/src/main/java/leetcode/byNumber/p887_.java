package leetcode.byNumber;

import org.junit.Test;

public class p887_ {

    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];

        for (int i = 0; i < k + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[1][i] = i;
        }
        for (int j = 1; j <= n; j++) {
            for (int i = 2; i <= k; i++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] , dp[i][n - j]) + 1;
            }

        }
        return dp[k][n];
    }

    @Test
    public void test() {
        System.out.println(superEggDrop(1, 5));
        System.out.println(superEggDrop(2, 3));
        System.out.println(superEggDrop(2, 5));
    }
}
