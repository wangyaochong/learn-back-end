package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getResult(new ArrayList<>(), result, nums, 0);
        return result;
    }

    public void getResult(List<Integer> tmpResult, List<List<Integer>> totalResult, int[] candidate, int lastLoc) {
        totalResult.add(new ArrayList<>(tmpResult));
        for (int i = lastLoc; i < candidate.length; i++) {
            tmpResult.add(candidate[i]);
            getResult(tmpResult, totalResult, candidate, i + 1);
            tmpResult.remove(tmpResult.size() - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

}
