package leetcode.byNumber;

import org.junit.Test;

public class p859_buddyStrings {
    public boolean buddyStrings(String a, String b) {

        Character c1 = null;
        Character c2 = null;
        if (a.length() != b.length()) {
            return false;
        }
        if (a.equals(b)) {
            char[] c=new char[26];
            for (int j = 0; j < a.length(); j++) {
                if(++c[a.charAt(j)-'a']>=2){
                    return true;
                }
            }
            return false;

        }
        int i = 0;
        int count = 0;
        while (i < a.length()) {
            if (a.charAt(i) != b.charAt(i)) {
                if (count == 0) {
                    count++;
                    c1 = a.charAt(i);
                    c2 = b.charAt(i);
                } else if (count == 1) {
                    if (c1 == b.charAt(i) && c2 == a.charAt(i)) {
                        count++;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            i++;
        }
        if (count == 1) {
            return false;
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(buddyStrings("aa", "aa"));
        System.out.println(buddyStrings("ab", "ba"));
        System.out.println(buddyStrings("ac", "bc"));
        System.out.println(buddyStrings("aa", "aa"));
    }
}
