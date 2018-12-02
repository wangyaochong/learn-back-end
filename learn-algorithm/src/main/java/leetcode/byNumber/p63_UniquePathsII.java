package leetcode.byNumber;

import org.junit.Test;

public class p63_UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                } else if (i == 0) {
                    dp[0][j] = (obstacleGrid[0][j] == 1) ? 0 : dp[0][j - 1];
                } else if (j == 0) {
                    dp[i][0] = (obstacleGrid[i][0] == 1) ? 0 : dp[i - 1][0];
                } else {
                    dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : (dp[i - 1][j] + dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    @Test
    public void test() {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 1, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}}));
    }
}
