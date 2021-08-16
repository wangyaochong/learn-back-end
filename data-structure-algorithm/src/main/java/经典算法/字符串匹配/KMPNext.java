package 经典算法.字符串匹配;

import org.junit.Test;

import java.util.Arrays;

public class KMPNext {
    int[] getNext(String pattern) {
        int[] result = new int[pattern.length()];
        //-1是终止标记，不然字符串无法区分是首字符还是没有对应的前缀
        result[0] = -1;

        int preLoc = -1;
        int postLoc = 0;
        while (postLoc < pattern.length()) {
            if (preLoc == -1) {
                preLoc++;
                postLoc++;
            }
            if (postLoc < pattern.length() && pattern.charAt(preLoc) == pattern.charAt(postLoc)) {
                if (postLoc >= 1) {
                    result[postLoc] = result[postLoc - 1] + 1;
                } else {
                    result[postLoc] = 1;
                }
                preLoc++;
                postLoc++;
            } else {
                preLoc = result[preLoc];
            }

        }
        return result;
    }

    int[] getNext2(String pattern) {
        int[] next = new int[pattern.length()];
        //-1是终止标记，不然字符串无法区分是首字符还是没有对应的前缀
        next[0] = -1;
        int preLoc = -1;
        int postLoc = 0;
        while (postLoc < pattern.length()) {
            if (preLoc == -1) {
                preLoc++;
                postLoc++;
            }
            if (postLoc < pattern.length()) {
                if (pattern.charAt(preLoc) == pattern.charAt(postLoc)) {
                    next[postLoc] = next[preLoc];
                    preLoc++;
                    postLoc++;
                } else {
                    next[postLoc] = preLoc;
                    preLoc = next[preLoc];
                }
            }
        }
        return next;
    }

    int[] getNext3(String pattern) {
        int[] next = new int[pattern.length()];
        //-1是终止标记，不然字符串无法区分是首字符还是没有对应的前缀
        next[0] = -1;
        int preLoc = 0;
        int postLoc = 1;
        while (postLoc < pattern.length()) {
            if (pattern.charAt(preLoc) == pattern.charAt(postLoc)) {
                next[postLoc] = next[preLoc];
                preLoc++;
                postLoc++;
            } else {
                next[postLoc] = preLoc;
                preLoc = next[preLoc];
            }
            if (preLoc == -1) {
                preLoc++;
                postLoc++;
            }
        }
        return next;
    }

    int[] getNext4(String pattern) {
        int preLoc = -1;
        int postLoc = 0;
        int[] next = new int[pattern.length()];
        //-1是终止标记，不然字符串无法区分是首字符还是没有对应的前缀
        next[0] = -1;

        while (postLoc < pattern.length() - 1) {
            if (preLoc == -1 || pattern.charAt(preLoc) == pattern.charAt(postLoc)) {
                preLoc++;
                postLoc++;
                next[postLoc] = preLoc;
            } else {
                preLoc = next[preLoc];
            }
        }
        return next;

    }

    int[] getNext5(String pattern) {
        int matchLength = -1;
        int currentLoc = 0;
        int[] next = new int[pattern.length()];
        //-1是终止标记，不然字符串无法区分是首字符还是没有对应的前缀
        next[0] = -1;

        while (currentLoc < pattern.length() - 1) {
            if (matchLength == -1 || pattern.charAt(matchLength) == pattern.charAt(currentLoc)) {
                matchLength++;
                currentLoc++;
                next[currentLoc] = matchLength;
            } else {
                matchLength = next[matchLength];
            }
        }
        return next;

    }

    public int[] myNext(String p) {
        int postLoc = 0;
        int preLoc = -1;
        int[] next = new int[p.length()];
        next[0] = -1;
        while (postLoc < p.length() - 1) {
            if (preLoc == -1 || p.charAt(postLoc) == p.charAt(preLoc)) {
                postLoc++;
                preLoc++;
                next[postLoc] = preLoc;
            } else {
                preLoc = next[preLoc];
            }
        }
        return next;
    }

    @Test
    public void test() {
        //从1到5是依次优化的过程
        System.out.println(Arrays.toString(getNext("ababc")));
        System.out.println(Arrays.toString(getNext2("ababc")));
        System.out.println(Arrays.toString(getNext3("ababc")));
        System.out.println(Arrays.toString(getNext4("ababc")));
        System.out.println(Arrays.toString(getNext5("ababc")));
        System.out.println(Arrays.toString(myNext("ababc")));
    }
}
