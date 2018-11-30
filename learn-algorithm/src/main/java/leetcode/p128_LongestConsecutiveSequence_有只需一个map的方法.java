package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class p128_LongestConsecutiveSequence_有只需一个map的方法 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> cacheEnd = new HashMap<>();
        Map<Integer, Integer> cacheStart = new HashMap<>();
        Map<Integer, Boolean> cacheVisit = new HashMap<>();
        for (int num : nums) {
            cacheStart.put(num, num);
            cacheEnd.put(num, num);
        }
        int count = 0;
        for (int num : nums) {
            if (cacheVisit.containsKey(num)) {
                continue;
            }
            Integer end = cacheEnd.get(num + 1);
            Integer start = cacheStart.get(num - 1);
            if (end == null) {
                end = num;
            }
            if (start == null) {
                start = num;
            }
            cacheEnd.put(start, end);
            cacheStart.put(end, start);
            cacheVisit.put(num, true);
            if (count < end - start + 1) {
                count = end - start + 1;
            }
        }
        return count;
    }

    @Test
    public void testLong() {
//        System.out.println(longestConsecutive(new int[]{1, 2, 3, 4, 5}));
//        System.out.println(longestConsecutive(new int[]{1, 2}));
//        System.out.println(longestConsecutive(new int[]{9, 1, 2, 0, -1, 1}));
//        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
//        System.out.println(longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6}));
        System.out.println(longestConsecutive(new int[]{4, 3, 7, 5, 8, 6, 9}));
//        System.out.println(longestConsecutive(new int[]{}));
    }

    @Test
    public void test() {
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(1, true);
        map.put(2, true);
        map.put(2, false);
        System.out.println(map);
    }

}
