package leetcode.byNumber;

import org.junit.Test;

public class p97_InterleavingString_这道题也可以用动态规划 {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return getResult(s1, s2, s3, 0, 0, 0, new Boolean[s1.length() + 1][s2.length() + 1]);
    }

    public boolean getResult(String s1, String s2, String target, int s1Loc, int s2Loc, int targetLoc, Boolean[][] cache) {
        if (s1Loc == s1.length() && s2Loc == s2.length()) {
            return true;
        }
        Boolean result = cache[s1.length() - s1Loc][s2.length() - s2Loc];
        if (result != null) {
            return result;
        }

        boolean match = s1Loc < s1.length() && s1.charAt(s1Loc) == target.charAt(targetLoc) && getResult(s1, s2, target, s1Loc + 1, s2Loc, targetLoc + 1, cache) ||
                s2Loc < s2.length() && s2.charAt(s2Loc) == target.charAt(targetLoc) && getResult(s1, s2, target, s1Loc, s2Loc + 1, targetLoc + 1, cache);
        cache[s1.length() - s1Loc][s2.length() - s2Loc] = match;
        return match;
    }

    @Test
    public void test() {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
