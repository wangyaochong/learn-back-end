package leetcode.byNumber;

import org.junit.Test;

public class p115_DistinctSubsequences_讨论中的解释很棒 {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j < s.length(); j++) {
            dp[0][j] = 1;
        }

        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    //如果两个字符串相等，则
                    //1、可以选择匹配，那么加上前一段匹配的数量
                    //2、可以选择不匹配，则当前值=该值与前面j-1个字符串匹配的数量
                    dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j];
                } else {

                    //如果两个字符串不相等，则当前值等于与前面j-1个字符串匹配的数量
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }

        return dp[t.length()][s.length()];
    }

    @Test
    public void test() {
        System.out.println(numDistinct("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc",
                "bcddceeeebecbc"));
    }
}
