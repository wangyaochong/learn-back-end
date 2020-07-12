package leetcode.byNumber;

import org.junit.Test;

public class p10_hard_RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new boolean[p.length() + 1];
        }
        dp[0][0] = true;//长度为0是可以匹配的
        int tmp = 1;
        while (tmp < p.length() && p.charAt(tmp) == '*') { //类似a*b*c*是可以匹配长度为0的字符串的
            dp[0][tmp + 1] = true;
            tmp += 2;
        }

        for (int sloc = 0; sloc < s.length(); sloc++) {
            for (int ploc = 0; ploc < p.length(); ploc++) {
                if (p.charAt(ploc) == '*') {
                    dp[sloc + 1][ploc + 1] = dp[sloc + 1][ploc - 1];//不匹配字符一定是可以的
                    if (p.charAt(ploc - 1) == s.charAt(sloc) || p.charAt(ploc - 1) == '.') {
                        //是同一个字符或者是.就可以匹配一个或者多个
                        dp[sloc + 1][ploc + 1] = dp[sloc + 1][ploc + 1]
                                || dp[sloc][ploc] //匹配一个字符
                                || dp[sloc][ploc + 1]; //匹配多个字符
                    }
                } else if (p.charAt(ploc) == '.' || p.charAt(ploc) == s.charAt(sloc)) {
                    dp[sloc + 1][ploc + 1] = dp[sloc][ploc];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    @Test
    public void test() {
        String s = "aab";
        String p = "c*a*b";
        boolean match = isMatch(s, p);
        assert match;

        String s1 = "aaa";
        String p1 = "ab*ac*a";
        boolean match1 = isMatch(s1, p1);
        assert match1;

        String s2 = "aaa";
        String p2 = "ab*a*c*a";
        boolean match2 = isMatch(s2, p2);
        assert match2;

    }
}
