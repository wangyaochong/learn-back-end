package leetcode.byNumber;

import org.junit.Test;

import java.nio.channels.SeekableByteChannel;
import java.util.*;

public class p76_minWindow {
    @Test
    public void test() {
//        String s = minWindow("ADOBECODEBANC", "ABC");
        String s = minWindow("cabwefgewcwaefgcf", "cae");
//        String s = minWindow("ADOBECODEBANC", "ABC");
        String s1 = minWindow("a", "aa");
        String s2 = minWindow("aa", "aa");
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
    }

    public String minWindow(String s, String t) {

        int resultStart = -1;
        int resultEnd =1000000;

        int tmpStart = 0;
        int tmpEnd = 0;
        int[] need = new int[128];
        int needCount = t.length();
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        while (tmpEnd < s.length()) {
            if (need[s.charAt(tmpEnd)] > 0) {
                needCount -= 1;
            }
            need[s.charAt(tmpEnd)] -= 1;
            if (needCount == 0) {
                while (true) {
                    need[s.charAt(tmpStart)]++;
                    tmpStart++;
                    if (need[s.charAt(tmpStart - 1)] >= 1) {//到了最短需要的位置了
                        needCount++;
                        if (resultEnd - resultStart > tmpEnd - tmpStart) {
                            //如果子串更短
                            resultStart = tmpStart - 1;
                            resultEnd = tmpEnd;
                        }
                        break;
                    }
                }
            }
            tmpEnd++;
        }
        if (resultStart == -1) {
            return "";
        }
        return s.substring(resultStart, resultEnd + 1);
    }
}
