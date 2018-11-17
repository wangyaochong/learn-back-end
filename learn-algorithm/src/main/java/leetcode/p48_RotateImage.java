package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class p48_RotateImage {
    public void rotate(int[][] matrix) {
        upsideDown(matrix);
        flipDiagonal(matrix);
    }

    public void flipDiagonal(int[][] matrix) {
        int tmp;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public void upsideDown(int[][] matrix) {
        int cur, len, tmp;
        for (int i = 0; i < matrix.length; i++) {
            cur = 0;
            len = matrix.length - 1;
            while (cur < len - cur) {
                tmp = matrix[cur][i];
                matrix[cur][i] = matrix[len - cur][i];
                matrix[len - cur][i] = tmp;
                cur++;
            }
        }
    }

    @Test
    public void test() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
