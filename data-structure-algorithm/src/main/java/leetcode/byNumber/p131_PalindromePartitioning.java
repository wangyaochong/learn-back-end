package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p131_PalindromePartitioning {
    @Test
    public void test() {
        System.out.println(partition("aabb"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        getResult(result, new ArrayList<>(), s, 0);
        return result;
    }

    public void getResult(List<List<String>> result, List<String> tmpResult, String candidate, int start) {
        if (start == candidate.length()) {
            result.add(new ArrayList<>(tmpResult));
            return;
        }
        for (int i = start; i < candidate.length(); i++) {
            String substring = candidate.substring(start, i + 1);
            if (isPalindrome(substring)) {
                tmpResult.add(substring);
                getResult(result, tmpResult, candidate, i + 1);
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
