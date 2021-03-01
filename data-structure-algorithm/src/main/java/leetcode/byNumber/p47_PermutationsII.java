package leetcode.byNumber;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class p47_PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
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
        int i = 0;
        while (i < list.size()) {
            while (i + 1 < list.size() && list.get(i).equals(list.get(i + 1))) {
                i++;
            }
            Integer remove = list.remove(i);//这是需要对list进行删除和添加操作，效率会更慢一些
            curResult.add(remove);
            getResult(list, curResult, result);
            curResult.remove(curResult.size() - 1);
            list.add(i, remove);
            i++;
        }
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        getResult2(nums, new ArrayList<>(), result, new int[nums.length], 0);
        return result;
    }

    public void getResult2(int[] nums, List<Integer> curResult, List<List<Integer>> result, int[] used, int depth) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(curResult));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            used[i] = 1;
            curResult.add(nums[i]);
            getResult2(nums, curResult, result, used, depth + 1);
            curResult.remove(curResult.size() - 1);
            used[i] = 0;
        }
    }


    @Test
    public void test() {
        List<List<Integer>> permute = permuteUnique2(new int[]{1, 1, 2});
        System.out.println(permute);
    }

    @Test
    public void test2() {
        System.out.println(DateFormatUtils.format(new Date(0), "yyyy-MM-dd HH:mm:ss"));
    }
}
