package leetcode.byNumber;

import org.junit.Test;

public class p79_WordSearch {
    @Test
    public void test() {
        System.out.println(exist(new char[][]{{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}}, "abcced"));
    }


    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && !flag) {
                    search(board, new boolean[board.length][board[0].length], i, j, word, 0);
                }
            }
        }
        return flag;
    }

    boolean flag = false;

    public void search(char[][] board, boolean[][] visited, int i, int j, String word, int w) {
        if (flag) {
            return;
        }

        visited[i][j] = true;
        if (board[i][j] == word.charAt(w)) {
            if (w == word.length() - 1) {
                flag = true;
                return;
            }
            if (i - 1 >= 0 && !visited[i - 1][j]) {
                search(board, visited, i - 1, j, word, w + 1);
            }
            if (i + 1 < board.length && !visited[i + 1][j]) {
                search(board, visited, i + 1, j, word, w + 1);
            }
            if (j - 1 >= 0 && !visited[i][j - 1]) {
                search(board, visited, i, j - 1, word, w + 1);
            }
            if (j + 1 < board[0].length && !visited[i][j + 1]) {
                search(board, visited, i, j + 1, word, w + 1);
            }
        }
        visited[i][j] = false;
    }
}
