package leetcode.byNumber;

import java.util.HashMap;
import java.util.Map;

public class p219_ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numLoc = new HashMap<>();
        int minLoc = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            Integer integer = numLoc.get(nums[i]);
            if (integer != null) {
                if (minLoc > i - integer) {
                    minLoc = i - integer;
                }
            }
            numLoc.put(nums[i], i);
        }
        return minLoc <= k;
    }
}
