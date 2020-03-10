package leetcode.byNumber;

import org.junit.Test;

public class p87_ScrambleString_理解 {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int[] tmp = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            tmp[s1.charAt(i) - 'a']++;
            tmp[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (tmp[i] != 0) {
                return false;
            }
        }
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(isScramble("great", "rgeat"));
    }

}
