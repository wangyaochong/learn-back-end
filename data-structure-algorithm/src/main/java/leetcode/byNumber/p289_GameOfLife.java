package leetcode.byNumber;

public class p289_GameOfLife {
    public void gameOfLife(int[][] board) {
        /**
         * 2，更新之前=0，更新后=1
         * 3，更新之前=1，更新后=0
         */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveCount = liveCount(board, i, j);
                if (board[i][j] == 0) {
                    if (liveCount == 3) {
                        board[i][j] = 2;
                    }
                } else {
                    if (liveCount < 2) {
                        board[i][j] = 3;
                    }
                    if (liveCount > 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
                if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public int liveCount(int[][] board, int x, int y) {
        int count = 0;
        if (x + 1 < board.length && (board[x + 1][y] == 1 || board[x + 1][y] == 3)) {
            count++;
        }
        if (x - 1 >= 0 && (board[x - 1][y] == 1 || board[x - 1][y] == 3)) {

            count++;
        }
        if (y + 1 < board[0].length && (board[x][y + 1] == 1 || board[x][y + 1] == 3)) {

            count++;
        }
        if (y - 1 >= 0 && (board[x][y - 1] == 1 || board[x][y - 1] == 3)) {
            count++;
        }
        if (x - 1 >= 0 && y - 1 >= 0 && (board[x - 1][y - 1] == 1 || board[x - 1][y - 1] == 3)) {
            count++;
        }
        if (x + 1 < board.length && y + 1 < board[0].length && (board[x + 1][y + 1] == 1 || board[x + 1][y + 1] == 3)) {
            count++;
        }
        if (x - 1 >= 0 && y + 1 < board[0].length && (board[x - 1][y + 1] == 1 || board[x - 1][y + 1] == 3)) {
            count++;
        }
        if (x + 1 < board.length && y - 1 >= 0 && (board[x + 1][y - 1] == 1 || board[x + 1][y - 1] == 3)) {
            count++;
        }
        return count;
    }
}



