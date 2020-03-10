package leetcode.byCategory.递归;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 八皇后 {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] map = new boolean[n][n];
        List<Integer> rowCandidate = new ArrayList<>();
        List<Integer> colCandidate = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rowCandidate.add(i);
            colCandidate.add(i);
        }
        solve(map, rowCandidate, colCandidate, 0, n);
        return null;
    }
//
//    public boolean check(boolean[][] map) {
//        //是否在同一撇行
//        List<Integer> addCheck = new ArrayList<>();
//        //是否在同一捺行
//        List<Integer> subCheck = new ArrayList<>();
//        //是否在同一行
//        List<Integer> rowCheck = new ArrayList<>();
//        //是否在同一列
//        List<Integer> colCheck = new ArrayList<>();
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map.length; j++) {
//                if (map[i][j]) {
//                    if (addCheck.contains(i + j) || subCheck.contains(i - j) || rowCheck.contains(i) || colCheck.contains(j)) {
//                        return false;
//                    }
//                    addCheck.add(i + j);
//                    subCheck.add(i - j);
//                    rowCheck.add(i);
//                    colCheck.add(j);
//                }
//            }
//        }
//        return true;
//    }


    int[] addCache = new int[100];
    int[] subCache = new int[100];

    int count = 0;



    public void solve(boolean[][] map, List<Integer> rowCandidate, List<Integer> colCandidate, int queenCount, int totalCount) {
        if (queenCount == totalCount) {
            for (int i = 0; i < map.length; i++) {
                boolean[] booleans = map[i];
                System.out.println(Arrays.toString(booleans));
            }
            System.out.println("----------------");
            return;
        }
        //当前位置不放皇后
        for (int i = 0; i < rowCandidate.size(); i++) {
            for (int j = 0; j < colCandidate.size(); j++) {
                if (addCache[rowCandidate.get(i) + colCandidate.get(j)] != 1 && subCache[rowCandidate.get(i) - colCandidate.get(j) + map.length] != 1) {
                    count++;
                    Integer row = rowCandidate.remove(i);
                    Integer col = colCandidate.remove(j);
                    addCache[row + col] = 1;
                    subCache[row - col + map.length] = 1;
                    map[row][col] = true;
                    solve(map, rowCandidate, colCandidate, queenCount + 1, totalCount);
                    map[row][col] = false;
                    addCache[row + col] = 0;
                    subCache[row - col + map.length] = 0;
                    rowCandidate.add(i, row);
                    colCandidate.add(j, col);
                }
            }
        }
    }

    @Test
    public void test() {
        solveNQueens(4);
        System.out.println(count);
    }

    @Test
    public void testDisplayMath() {
        int n = 4;
        int[][] result = new int[4][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = i;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

    }
}
