package leetcode.byNumber;

import org.junit.Test;

public class p345_ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        char tmp;
        while (start < end) {
            while (start < end && !isVowels(chars[start])) {
                start++;
            }
            while (start < end && !isVowels(chars[end])) {
                end--;
            }
            if (start < end) {
                tmp = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp;
            }
            start++;
            end--;
        }
        return new String(chars);
    }

    public boolean isVowels(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'o' || c == 'O' || c == 'i' || c == 'I' || c == 'u' || c == 'U';
    }

    @Test
    public void test() {
        System.out.println(reverseVowels("HELLO"));
    }
}
