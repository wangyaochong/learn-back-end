package leetcode.byCategory.递归;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class 八皇后超级简单 {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] map = new boolean[n][n];
        solve(map, 0, 0, n);
        return null;
    }

    int[] addCache = new int[100];
    int[] subCache = new int[100];
    int[] rowCache = new int[100];


    public void solve(boolean[][] map, int col, int queenCount, int totalCount) {
        if (queenCount == totalCount) {
            for (int i = 0; i < map.length; i++) {
                boolean[] booleans = map[i];
                System.out.println(Arrays.toString(booleans));
            }
            System.out.println("----------------");
            return;
        }
        for (int i = 0; i < map.length; i++) {
            if (rowCache[i] == 0 && addCache[i + col] != 1 && subCache[i - col + map.length] != 1) {
                addCache[i + col] = 1;
                subCache[i - col + map.length] = 1;
                map[i][col] = true;
                rowCache[i] = 1;
                solve(map, col + 1, queenCount + 1, totalCount);
                rowCache[i] = 0;
                map[i][col] = false;
                addCache[i + col] = 0;
                subCache[i - col + map.length] = 0;
            }
        }
    }

    @Test
    public void test() {
        solveNQueens(4);
    }
}
