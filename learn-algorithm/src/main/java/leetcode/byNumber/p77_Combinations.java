package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> candiate = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            candiate.add(i + 1);
        }
        List<List<Integer>> result = new ArrayList<>();
        getResult(candiate, new ArrayList<>(), result, k, 0);
        return result;
    }

    public void getResult(List<Integer> candidate, List<Integer> tmpResult, List<List<Integer>> result, Integer leftCount, int lastLoc) {
        if (leftCount == 0) {
            result.add(new ArrayList<>(tmpResult));
        }
        for (int i = lastLoc; i < candidate.size(); i++) {
            tmpResult.add(candidate.get(i));
            getResult(candidate, tmpResult, result, leftCount - 1, i + 1);
            tmpResult.remove(tmpResult.size() - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(combine(4, 2));
    }
}
