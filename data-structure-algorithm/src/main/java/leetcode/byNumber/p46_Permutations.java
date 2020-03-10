package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        List<List<Integer>> result = new ArrayList<>();
        getResult(list, new ArrayList<>(), result);
        return result;
    }

    public void getResult(List<Integer> list, List<Integer> curResult, List<List<Integer>> result) {
        if (list.size() == 0) {
            result.add(new ArrayList<>(curResult));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            Integer remove = list.remove(i);
            curResult.add(remove);
            getResult(list, curResult, result);
            curResult.remove(curResult.size() - 1);
            list.add(i, remove);
        }
    }

    @Test
    public void test() {
        List<List<Integer>> permute = permute(new int[]{1, 1, 2});
        System.out.println(permute);
    }

}
