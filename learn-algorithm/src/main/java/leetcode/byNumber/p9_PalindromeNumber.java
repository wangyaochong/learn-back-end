package leetcode.byNumber;

import org.junit.Test;

public class p9_PalindromeNumber {

    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int start = 0;
        int end = s.length() - 1;

        while (start <= end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        if (start < end) {
            return false;
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(isPalindrome(0));
    }
}
