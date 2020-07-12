package leetcode.byNumber;

import org.junit.Test;

public class p5_LongestPalindromicSubstring {
    int locStart = 0;
    int locEnd = -1;
    public String longestPalindrome(String s) {

        for (int i = 0; i < s.length(); i++) {
            search(s, i, i);
            search(s, i, i + 1);
        }

        return s.substring(locStart, locEnd + 1);
    }

    public void search(String s, int locStartLeft, int locStartRight) {
        while (locStartLeft >= 0 && locStartRight < s.length() && s.charAt(locStartLeft) == s.charAt(locStartRight)) {
            if (locEnd - locStart < locStartRight - locStartLeft) {
                locStart = locStartLeft;
                locEnd = locStartRight;
            }
            locStartLeft--;
            locStartRight++;
        }
    }
}
