package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p132 {

    @Test
    public void test() {
        System.out.println(minCut("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi"));
    }

    public int minCut(String s) {
        if (isPalindrome(s)) {
            return 0;
        }
        for (int i = 1; i <= s.length() && min == Integer.MAX_VALUE; i++) {
            getResult(new ArrayList<>(), s, 0, i);
        }
        return min;
    }

    int min = Integer.MAX_VALUE;
    Map<String, Boolean> cache = new HashMap<>();

    public void getResult(List<String> tmpResult, String candidate, int start, int leftCount) {
        if (start == candidate.length()) {
            if (min > tmpResult.size() - 1) {
                min = tmpResult.size() - 1;
            }
            return;
        }
        if (leftCount == 0) {
            return;
        }
        for (int i = start; i < candidate.length(); i++) {
            String substring = candidate.substring(start, i + 1);
            Boolean aBoolean = cache.get(substring);
            if (aBoolean == null) {
                aBoolean = isPalindrome(substring);
                cache.put(substring, aBoolean);
            }
            if (aBoolean) {
                tmpResult.add(substring);
                getResult(tmpResult, candidate, i + 1, leftCount - 1);
                tmpResult.remove(tmpResult.size() - 1);
            }
        }
        return;
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
