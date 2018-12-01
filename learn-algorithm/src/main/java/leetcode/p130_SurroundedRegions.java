package leetcode;

import org.junit.Test;

public class p130_SurroundedRegions {


    public void search(char[][] board, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == 'O') {
            board[i][j] = '*';
            search(board, i + 1, j);
            search(board, i - 1, j);
            search(board, i, j + 1);
            search(board, i, j - 1);
        }
    }
    
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            search(board, i, 0);
            search(board, i, board[0].length - 1);
        }
        for (int i = 0; board.length > 0 && i < board[0].length; i++) {
            search(board, 0, i);
            search(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }


    @Test
    public void test() {

    }
}
