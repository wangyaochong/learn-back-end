package structure.tree;

import org.junit.Test;

public class Trie {

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

    @Test
    public void test() {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("abc"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    @Test
    public void testMaxIndex() {
        System.out.println('z' - 'a');
    }
}
