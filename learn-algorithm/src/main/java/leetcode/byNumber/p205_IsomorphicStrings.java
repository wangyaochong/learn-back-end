package leetcode.byNumber;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class p205_IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> cache = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character character = cache.get(s.charAt(i));
            Character character2 = cache.get((char) (t.charAt(i) + 100));
            if (character == null && character2 == null) {
                cache.put(s.charAt(i), t.charAt(i));
                cache.put((char) (t.charAt(i) + 100), s.charAt(i));
            } else {
                if (character != null && character.compareTo(t.charAt(i)) != 0 || character2.compareTo(s.charAt(i)) != 0) {
                    return false;
                }
            }
        }

        return true;
    }


    @Test
    public void test() {
        System.out.println(isIsomorphic("pa1er", "title"));
    }
}
