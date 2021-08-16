package leetcode.byNumber;

import org.junit.Test;

public class p516_longestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        if (s.length() <= 1) {
            return s.length();
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (i == j) {
                    dp[j][i] = 1;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[j][i] = dp[j + 1][i - 1] + 2;
                    } else if (s.charAt(i) != s.charAt(j)) {
                        dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    @Test
    public void test() {
        System.out.println(longestPalindromeSubseq("abcdcba"));
        System.out.println(longestPalindromeSubseq("abcsdcbax"));
        System.out.println(longestPalindromeSubseq("abcdcscba"));
    }
}
