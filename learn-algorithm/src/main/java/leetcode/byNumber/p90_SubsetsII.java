package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p90_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        getResult(nums, new ArrayList<>(), result, 0);
        return result;
    }

    public void getResult(int[] candidate, List<Integer> tmpResult, List<List<Integer>> finalResult, int lastLoc) {
        finalResult.add(new ArrayList<>(tmpResult));
        for (int i = lastLoc; i < candidate.length; i++) {//起点是lastLoc，不能回查之前，因为set与顺序无关
            int sameCount = 0;
            while (i + 1 < candidate.length && candidate[i] == candidate[i + 1]) {//在当前这一层只查询一次
                sameCount++;
                i++;
            }
            tmpResult.add(candidate[i]);
            getResult(candidate, tmpResult, finalResult, i + 1 - sameCount);
            tmpResult.remove(tmpResult.size() - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(subsetsWithDup(new int[]{2, 2, 3}));
    }

}
