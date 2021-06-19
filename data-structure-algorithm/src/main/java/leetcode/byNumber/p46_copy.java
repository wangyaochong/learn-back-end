package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p46_copy {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        solve(nums, new int[nums.length], 0, new ArrayList<>(), result);
        return result;
    }

    public void solve(int[] candidate, int[] flag, int count, List<Integer> one, List<List<Integer>> result) {
        if (count == candidate.length) {
            result.add(new ArrayList<>(one));
            return;
        }
        for (int i = 0; i < candidate.length; i++) {
            if (flag[i] == 0) {
                flag[i] = 1;
                one.add(candidate[i]);
                solve(candidate, flag, count + 1, one, result);
                one.remove(one.size() - 1);
                flag[i] = 0;
            }

        }
    }
    @Test
    public void test(){
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}
