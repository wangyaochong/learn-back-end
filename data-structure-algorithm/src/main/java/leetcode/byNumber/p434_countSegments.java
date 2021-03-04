package leetcode.byNumber;

import org.junit.Test;

public class p434_countSegments {
    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                count++;
                while (i + 1 < s.length() && s.charAt(i + 1) != ' ') i++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(countSegments(" abc efg a"));
    }
}
