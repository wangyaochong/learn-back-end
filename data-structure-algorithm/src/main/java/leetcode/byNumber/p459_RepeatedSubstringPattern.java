package leetcode.byNumber;

import org.junit.Test;

public class p459_RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        String s1 = s + s;
        int i = s1.indexOf(s, 1);
        return i != -1 && i != s.length();
    }
      public boolean repeatedSubstringPattern2(String s) {
        String s1 = s + s;
          return s1.substring(1, s1.length() - 1).contains(s);
    }

    @Test
    public void test(){
        boolean str = repeatedSubstringPattern("abab");
        System.out.println(str);
    }
}
