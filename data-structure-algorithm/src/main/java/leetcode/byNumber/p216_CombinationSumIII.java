package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p216_CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<Integer> candidate = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<List<Integer>> result = new ArrayList<>();
        getResult(candidate, new ArrayList<>(), result, n, k, 0);
        return result;
    }

    public void getResult(List<Integer> candidate, List<Integer> tmpResult, List<List<Integer>> result, int left, int count, int lastLoc) {
        if (left == 0 && count == 0) {
            result.add(new ArrayList<>(tmpResult));
            return;
        }
        if (count == 0 || left <= 0) {
            return;
        }
        for (int i = lastLoc; i < candidate.size(); i++) {
            tmpResult.add(candidate.get(i));
            getResult(candidate, tmpResult, result, left - candidate.get(i), count - 1, i + 1);
            tmpResult.remove(tmpResult.size() - 1);
        }
    }


    @Test
    public void test() {
        System.out.println(combinationSum3(3, 7));
    }
}
