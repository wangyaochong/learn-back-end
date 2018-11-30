package leetcode;

import org.junit.Test;

public class p125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();
        while (i < j) {
            while (i < j && !isWordChar(s.charAt(i))) {
                i++;
            }
            while (i < j && !isWordChar(s.charAt(j))) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isWordChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    @Test
    public void test() {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
