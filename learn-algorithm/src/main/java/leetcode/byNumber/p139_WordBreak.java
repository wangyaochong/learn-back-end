package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class p139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (String aWordDict : wordDict) {
                if (i >= aWordDict.length() && dp[i - aWordDict.length()] && s.substring(i - aWordDict.length(), i).equals(aWordDict)) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }


    @Test
    public void test() {
        System.out.println(wordBreak("aaaaa",
                Arrays.asList("aaa", "aa")));
    }
}
