package leetcode.byNumber;

import org.junit.Test;

public class p211_AddAndSearchWord {

    static public class Trie {
        static Trie flag = new Trie();
        Trie[] tries;

        public Trie() {
            tries = new Trie[27];
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            insertInner(word, 0);
        }

        public void insertInner(String word, int loc) {
            if (word == null || loc == word.length()) {
                tries[26] = flag;
                return;
            }
            int i = word.charAt(loc) - 'a';
            if (tries[i] == null) {
                tries[i] = new Trie();
            }
            tries[i].insertInner(word, loc + 1);
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            return searchInner(word, 0);
        }

        public boolean searchInner(String word, int loc) {
            if (word == null || word.length() == loc) {
                return tries[26] != null;
            }
            if (word.charAt(loc) == '.') {
                for (int j = 0; j < 27; j++) {
                    if (tries[j] != null && tries[j].searchInner(word, loc + 1)) {
                        return true;
                    }
                }
                return false;
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
    }


    Trie trie = new Trie();

    /**
     * Initialize your data structure here.
     */
    public void WordDictionary() {

    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        trie.insert(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return trie.search(word);
    }

    @Test
    public void test() {
        addWord("abc");
        addWord("bcd");
        System.out.println(search("abc"));
        System.out.println(search(".bc"));
        System.out.println(search("bbc"));
    }
}
