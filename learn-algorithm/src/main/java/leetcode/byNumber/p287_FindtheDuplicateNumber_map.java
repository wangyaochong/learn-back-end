package leetcode.byNumber;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class p287_FindtheDuplicateNumber_map {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = cache.putIfAbsent(nums[i], i);
            if (integer != null) {
                return nums[i];
            }
        }
        return 0;
    }

    @Test
    public void test() {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicate(new int[]{3, 2, 2, 2, 4}));
    }
}


