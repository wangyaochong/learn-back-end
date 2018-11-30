package leetcode;

import org.junit.Test;

import java.util.*;

public class p127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        getResult(beginWord, endWord, wordList, 0);
        return count == Integer.MAX_VALUE ? 0 : count + 1;
    }


    int count = Integer.MAX_VALUE;

    Map<String, List<String>> cache = new HashMap<>();


    public void getResult(String beginWord, String endWord, List<String> candidate, int currentCount) {
        if (beginWord.equals(endWord)) {
            if (count > currentCount) {
                count = currentCount;
            }
            return;
        }

        for (int i = 0; i < candidate.size(); i++) {
            if (cache.get(beginWord) == null) {
            }
            if (oneChange(candidate.get(i), beginWord)) {
                String remove1 = candidate.remove(i);
                getResult(remove1, endWord, candidate, currentCount + 1);
                candidate.add(i, remove1);
            }
        }


    }


    public boolean oneChange(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                count++;
            }
        }
        return count == s.length() - 1;

    }

    @Test
    public void test() {
        System.out.println(ladderLength("hit", "cdg", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "log", "cog", "cdg"))));
    }

}
