package leetcode.byNumber;

import org.junit.Test;

public class p14_LongestCommonPrefix_simple {
    @Test
    public void test() {
        String s = longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        String s2 = longestCommonPrefix(new String[]{"dog", "racecar", "car"});
    }


    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int curLoc = 0;
        while (curLoc < strs[0].length()) {
            boolean sameFlag = true;
            char c = strs[0].charAt(curLoc);
            for (int i = 1; i < strs.length; i++) {
                if (curLoc == strs[i].length() || c != strs[i].charAt(curLoc)) {
                    sameFlag = false;
                    break;
                }
            }
            if (!sameFlag) {
                break;
            }
            curLoc++;
        }
        if (curLoc == 0) {
            return "";
        }
        return strs[0].substring(0, curLoc);
    }
}
