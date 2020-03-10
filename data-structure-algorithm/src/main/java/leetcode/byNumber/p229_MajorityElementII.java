package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p229_MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            Integer integer = cache.putIfAbsent(num, 0);
            integer = integer == null ? 0 : integer;
            if (integer == -1) {
                continue;
            }
            if (integer + 1 > nums.length / 3) {
                result.add(num);
                cache.put(num, -1);
            } else {
                cache.put(num, integer + 1);
            }
        }
        return result;
    }


    @Test
    public void test() {
        System.out.println(majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));
    }
}
