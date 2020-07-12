package 经典算法.字符串匹配;

import org.junit.Test;

import java.util.Arrays;

public class KMPexercise2 {
    public int simple(String major, String pattern) {
        int m = 0;
        int p = 0;
        while (m < major.length() && p < pattern.length()) {
            if (major.charAt(m) == pattern.charAt(p)) {
                m++;
                p++;
            } else {
                m -= p - 1;
                p = 0;
            }
        }
        if (p == pattern.length()) {
            return m - p;
        }
        return -1;
    }

    @Test
    public void testSimple() {
        System.out.println(simple("abcdefg", "bcde"));
    }

    @Test
    public void testKMP() {
        System.out.println(kmp("abcdefg", "bcde"));
    }

    public int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int pre = -1;
        int post = 0;
        while (post < pattern.length() - 1) {
            if (pre == -1 || pattern.charAt(pre) == pattern.charAt(post)) {
                pre++;
                post++;
                if (pattern.charAt(pre) != pattern.charAt(post)) {
                    next[post] = pre;
                } else {
                    next[post] = next[pre];
                }
            } else {
                pre = next[pre];
            }
        }
        return next;
    }


    public int kmp(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        int m = 0;
        int p = 0;
        int[] next = getNext(needle);
        while (m < haystack.length() && p < needle.length()) {
            if (p == -1 || haystack.charAt(m) == needle.charAt(p)) {
                m++;
                p++;
            } else {
                p = next[p];
            }
        }
        if (p == needle.length()) {
            return m - p;
        }
        return -1;
    }
}
