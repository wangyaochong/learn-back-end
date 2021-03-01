package leetcode.byNumber;

import org.junit.Test;

public class p36_ValidSudoku {

    @Test
    public void test() {
        char[][] board = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        char[][] board2 = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku(board2));
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[10][10];
        int[][] col = new int[10][10];
        int[][] box = new int[10][10];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {

                } else {
                    if (row[i][board[i][j] - '0'] == 0) {
                        row[i][board[i][j] - '0'] = 1;
                    } else {
                        return false;
                    }
                    if (col[board[i][j] - '0'][j] == 0) {
                        col[board[i][j] - '0'][j] = 1;
                    } else {
                        return false;
                    }
                    int[] box1 = box[i / 3 * 3 + j / 3];
                    if (box1[board[i][j] - '0'] == 0) {
                        box1[board[i][j] - '0'] = 1;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
