package leetcode.byNumber;

import org.junit.Test;

public class p79_WordSearch_优化一版 {
    /**
     * 这一版不需要额外缓存
     */
    @Test
    public void test() {
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESEEEFS"));
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && search(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, int i, int j, String word, int w) {
        if (w == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
            return false;
        }
        boolean result = false;
        if (board[i][j] == word.charAt(w)) {
            board[i][j] += 1234;
            result = search(board, i - 1, j, word, w + 1) ||
                    search(board, i + 1, j, word, w + 1) ||
                    search(board, i, j - 1, word, w + 1) ||
                    search(board, i, j + 1, word, w + 1);
            board[i][j] -= 1234;
        }
        return result;
    }

    @Test
    public void testChar255() {
        System.out.println(Character.MAX_VALUE);
        System.out.println(Character.MIN_VALUE);

        System.out.println((char) ('A' + Character.MAX_VALUE));
        System.out.println(Character.MIN_VALUE);
    }
}
