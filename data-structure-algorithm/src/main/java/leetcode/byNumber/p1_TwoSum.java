package leetcode.byNumber;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class p1_TwoSum {
    @Test
    public void test() {

    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.get(target - nums[i]) == null) {
                numMap.put(nums[i], i);
            } else {
                result[0] = i;
                result[1] = numMap.get(target - nums[i]);
            }
        }
        return result;
    }
}
