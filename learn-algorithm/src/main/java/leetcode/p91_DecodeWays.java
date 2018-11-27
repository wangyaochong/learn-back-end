package leetcode;

import org.junit.Test;

public class p91_DecodeWays {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0') {
            dp[1] = 0;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < s.length() + 1; i++) {
            if (s.charAt(i - 1) - '0' >= 1 && s.charAt(i - 1) - '0' <= 9) {
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6') {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }


    @Test
    public void test() {
        System.out.println(numDecodings("01111"));
    }
}
