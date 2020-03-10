package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p212_WordSearchII {
    static public class Trie {
        static Trie flag = new Trie();
        Trie[] tries;
        private final Integer arraySize = 27;
        int count = 0;

        public Trie() {
            tries = new Trie[arraySize];
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            insertInner(word, 0);
        }

        public void insertInner(String word, int loc) {
            if (word == null || loc == word.length()) {//如果到达终点了
                tries[arraySize - 1] = flag;
                return;
            }
            int i = word.charAt(loc) - 'a';
            if (tries[i] == null) {
                tries[i] = new Trie();
            }
            tries[i].insertInner(word, loc + 1);
            tries[i].count++;//当前前缀出现次数+1
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            return searchInner(word, 0);
        }

        public boolean searchInner(String word, int loc) {
            if (word == null || word.length() == loc) {
                return tries[arraySize - 1] != null;
            }
            int i = word.charAt(loc) - 'a';
            if (tries[i] == null) {
                return false;
            }
            return tries[i].searchInner(word, loc + 1);
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return startWithInner(prefix, 0);
        }

        public boolean startWithInner(String prefix, int loc) {
            if (prefix == null || prefix.length() == loc) {
                return true;
            }
            int i = prefix.charAt(loc) - 'a';
            if (tries[i] == null) {
                return false;
            }
            return tries[i].startWithInner(prefix, loc + 1);
        }

        public boolean remove(String word) {
            return removeInner(word, 0);
        }

        public boolean removeInner(String word, int loc) {
            if (word == null || word.length() == loc) {
                tries[arraySize - 1] = null;
                return true;
            }
            int i = word.charAt(loc) - 'a';
            if (tries[i] == null) {
                return false;
            }
            boolean b = tries[i].removeInner(word, loc + 1);
            tries[i].count--;
            if (tries[i].count == 0) {
                tries[i] = null;
            }
            return b;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (trie.startsWith(String.valueOf(board[i][j]))) {
                    getResult(result, new StringBuilder(), board, i, j, trie);
                }
            }
        }
        return result;
    }

    private int searchCount = 0;

    public void getResult(List<String> result, StringBuilder stringBuilder, char[][] board, int i, int j, Trie trie) {
        searchCount++;
        String curString = stringBuilder.toString();
        if (!trie.startsWith(curString)) {
            return;
        }
        if (trie.search(curString)) {
            result.add(curString);
            trie.remove(curString);
        }
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] > 150) {
            return;
        }
        stringBuilder.append(board[i][j]);
        board[i][j] <<= 1;
        getResult(result, stringBuilder, board, i - 1, j, trie);
        getResult(result, stringBuilder, board, i + 1, j, trie);
        getResult(result, stringBuilder, board, i, j - 1, trie);
        getResult(result, stringBuilder, board, i, j + 1, trie);
        board[i][j] >>= 1;
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }

    @Test
    public void test() {
        System.out.println(
                findWords(
                        new char[][]{
                                {'o', 'a', 'a', 'n'},
                                {'e', 't', 'a', 'e'},
                                {'i', 'h', 'k', 'r'},
                                {'i', 'f', 'l', 'v'}
                        },
                        new String[]{"oath", "pea", "eat", "rain"}));
        System.out.println(searchCount);
    }


    @Test
    public void testCharacterRange() {
        for (int i = 'a'; i <= 'z'; i++) {
            System.out.println(i);
            System.out.println(i << 1);
        }
    }
}
