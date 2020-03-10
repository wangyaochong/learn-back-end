package structure.tree;

import org.junit.Test;

/**
 * 使用数组实现字典树（前缀树）
 */
public class TrieImplArray {

    static TrieImplArray flag = new TrieImplArray();

    TrieImplArray[] tries;
    private final Integer arraySize = 27;
    int count = 0;

    public TrieImplArray() {
        tries = new TrieImplArray[arraySize];
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
            tries[i] = new TrieImplArray();
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

    @Test
    public void test() {
        TrieImplArray trie = new TrieImplArray();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("abc"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
        System.out.println(trie.remove("app"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search("apple"));
    }

    @Test
    public void testMaxIndex() {
        System.out.println('z' - 'a');
    }


}
