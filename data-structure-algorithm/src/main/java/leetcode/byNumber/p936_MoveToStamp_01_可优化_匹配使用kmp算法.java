package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class p936_MoveToStamp_01_可优化_匹配使用kmp算法 {
    @Test
    public void test() {
        String stamp = "abc";
        int[] result = movesToStamp(stamp, "ababc");
        System.out.println(Arrays.toString(result));
    }

    public int match(StringBuilder target, String stamp, int start) {
        int i = 0;
        int startCount = 0;
        while (i < stamp.length() && start + i < target.length() &&
                (target.charAt(start + i) == stamp.charAt(i) || target.charAt(start + i) == '*')) {
            if (target.charAt(start + i) == '*') {
                startCount++;
            }
            i++;
        }
        if (i == stamp.length()) {
            return stamp.length() - startCount;
        } else {
            return -1;
        }
    }

    public int[] movesToStamp(String stamp, String target) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        while (count < stamp.length()) {
            builder.append("*");
            count++;
        }
        return movesToStamp(stamp, target, builder.toString());
    }

    public int[] movesToStamp(String stamp, String target, String mask) {
        StringBuilder targetBuilder = new StringBuilder(target);
        int[] stamppedLoc = new int[target.length()];
        int totalMatchCount = 0;
        List<Integer> result = new ArrayList<>();
        while (totalMatchCount < target.length()) {
            boolean hasMatch = false;
            for (int i = 0; i < target.length() - stamp.length() + 1; i++) {
                if (stamppedLoc[i] == 0) {
                    int matchCount = match(targetBuilder, stamp, i);
                    if (matchCount != -1) {
                        targetBuilder.replace(i, i + stamp.length(), mask);
                        stamppedLoc[i] = 1;
                        result.add(i);
                        hasMatch = true;
                        totalMatchCount += matchCount;
                        break;
                    }
                }

            }
            if (!hasMatch) {
                break;
            }
        }
        if (totalMatchCount != target.length()) {
            return new int[0];
        } else {
            Collections.reverse(result);
            return result.stream().mapToInt(e -> e).toArray();
        }
    }
}
