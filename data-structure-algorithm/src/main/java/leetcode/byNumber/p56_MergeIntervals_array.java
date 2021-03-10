package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;


public class p56_MergeIntervals_array {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int removeCount = 0;
        int left = 0;
        int right = 1;
        while (right < intervals.length) {
            if (intervals[left][0] != Integer.MAX_VALUE && intervals[left][1] >= intervals[right][0]) {
//                intervals[left][0] = Math.min(intervals[left][0], intervals[right][0]);
                intervals[left][1] = Math.max(intervals[left][1], intervals[right][1]);
                intervals[right][0] = Integer.MAX_VALUE;
                intervals[right][1] = Integer.MAX_VALUE;
                removeCount++;
                right++;
            } else {
                left++;
                if (left == right) {
                    right++;
                }
            }
        }

        int[][] result = new int[intervals.length - removeCount][2];
        removeCount = 0;
        for (int j = 0; j < intervals.length; j++) {
            if (intervals[j][0] != Integer.MAX_VALUE) {
                result[j - removeCount][0] = intervals[j][0];
                result[j - removeCount][1] = intervals[j][1];
            } else {
                removeCount++;
            }
        }

        return result;
    }

    @Test
    public void test() {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {4, 5}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}})));
    }
}
