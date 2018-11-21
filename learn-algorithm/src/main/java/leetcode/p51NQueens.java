package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class p51NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<Integer> rowLeft = new LinkedList<>();
        List<Integer> colLeft = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            rowLeft.add(i);
            colLeft.add(i);
        }
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        getResult(board, rowLeft, colLeft, new boolean[2 * n + 1], new boolean[2 * n + 1], result, 0);
        return result;
    }

    public void getResult(char[][] board, List<Integer> rowLeft, List<Integer> colLeft, boolean[] slashMinus, boolean[] slashPlus, List<List<String>> totalResult, int lastJ) {
        if (colLeft.size() == 0 && rowLeft.size() == 0) {
            List<String> oneResult = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                oneResult.add(new String(board[i]));
            }
            totalResult.add(new ArrayList<>(oneResult));
            return;
        }
        for (int i = 0; i < rowLeft.size(); i++) {
            Integer removeI = rowLeft.remove(i);
            for (int j = lastJ; j < colLeft.size(); j++) {
                Integer removeJ = colLeft.remove(j);
                if (slashPlus[removeI + removeJ]) {
                    colLeft.add(j, removeJ);
                    break;
                }
                slashPlus[removeI + removeJ] = true;
                if (slashMinus[removeI - removeJ + board.length]) {
                    slashPlus[removeI + removeJ] = false;
                    colLeft.add(j, removeJ);
                    break;
                }
                slashMinus[removeI - removeJ + board.length] = true;
                board[removeI][removeJ] = 'Q';
                getResult(board, rowLeft, colLeft, slashMinus, slashPlus, totalResult, j);
                board[removeI][removeJ] = '.';
                colLeft.add(j, removeJ);
                slashPlus[removeI + removeJ] = false;
                slashMinus[removeI - removeJ + board.length] = false;
            }
            rowLeft.add(i, removeI);
        }
    }


    @Test
    public void test() {
        System.out.println(solveNQueens(4));
    }

}
