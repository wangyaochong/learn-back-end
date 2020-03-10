package leetcode.byNumber;

import java.util.HashMap;
import java.util.Map;

public class p290_WordPattern {

    public boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        if (pattern.length() != s.length) {
            return false;
        }
        String[] cache = new String[30];
        Map<String, Character> revertMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            int loc = pattern.charAt(i) - 'a';
            String s1 = cache[loc];
            if (s1 == null) {
                cache[loc] = s[i];
            } else {
                if (!s1.equals(s[i])) {
                    return false;
                }
            }

            Character character = revertMap.get(s[i]);
            if (character == null) {
                revertMap.put(s[i], pattern.charAt(i));
            } else {
                if (character != pattern.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
