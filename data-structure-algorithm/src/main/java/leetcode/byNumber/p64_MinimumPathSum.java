package leetcode.byNumber;

import org.junit.Test;

public class p64_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[0][j] = dp[0][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][0] = dp[i - 1][0] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + grid[i][j], dp[i - 1][j] + grid[i][j]);
                }

            }
        }
        return dp[m - 1][n - 1];
    }

    @Test
    public void test() {
        System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
