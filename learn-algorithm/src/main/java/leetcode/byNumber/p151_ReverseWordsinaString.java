package leetcode.byNumber;

import org.junit.Test;

public class p151_ReverseWordsinaString {


    @Test
    public void test() {
        System.out.println(reverseWords("   2  12"));
    }

    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        int i = s.length() - 1;
        int j = 0;
        while (j < s.length() && s.charAt(j) == ' ') {
            j++;
        }
        while (i >= j) {
            while (i >= j && s.charAt(i) == ' ') {
                i--;
            }
            while (i >= j && s.charAt(i) != ' ') {
                tmp.append(s.charAt(i));
                i--;
            }
            result.append(tmp.reverse());
            tmp = new StringBuilder();
            if (i >= j) {
                result.append(' ');
            }
            i--;
        }
        return result.toString();
    }
}
