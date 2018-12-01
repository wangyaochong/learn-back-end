package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        List<String> result = new ArrayList<>();
        getResult(dp, s, "", result, wordDict, 0);
        return result;
    }

    public void getResult(boolean[] dp, String s, String tmpResult, List<String> result, List<String> candidate, int preLoc) {
        if (0 >= s.length()) {
            result.add(tmpResult.substring(0, tmpResult.length() - 1));
            return;
        }
        for (int i = 0; i <= s.length(); i++) {
            for (String one : candidate) {
                if (i >= one.length() && dp[i - one.length() + preLoc] && s.substring(i - one.length(), i).equals(one)) {
                    dp[preLoc + one.length()] = true;
                    getResult(dp, s.substring(one.length()), tmpResult + one + " ", result, candidate, one.length() + preLoc);
                    dp[preLoc + one.length()] = false;
                }
            }
        }
    }

    @Test
    public void test() {
        System.out.println(wordBreak("catsanddog", Arrays.asList("dog", "sand", "and", "cat")));
    }
}
