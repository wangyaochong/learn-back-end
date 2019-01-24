package leetcode.byNumber;

import org.junit.Test;

public class p304_RangeSumQuery2DImmutable {
    int[][] sumCache = null;

    public void NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int row = matrix.length + 1;
        int col = matrix[0].length + 1;
        sumCache = new int[row][col];
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                sumCache[i][j] = matrix[i - 1][j - 1] - sumCache[i - 1][j - 1] + sumCache[i - 1][j] + sumCache[i][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumCache[row2 + 1][col2 + 1] - sumCache[row2 + 1][col1] - sumCache[row1][col2 + 1] + sumCache[row1][col1];
    }


    @Test
    public void test() {
//1,1;
//1,1;
//1,2;
//2,4

//        NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        NumMatrix(new int[][]{{1, 1}, {1, 1}});
    }
}
