package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class p435_eraseOverlapIntervals_贪心 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals,Comparator.comparingInt(o -> o[0]));
        int end = intervals[0][1];
        int removeCount = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                removeCount++;
                if(end> intervals[i][1]){
                    end = intervals[i][1];
                }
            } else {
                end = intervals[i][1];
            }
        }
        return removeCount;
    }

    @Test
    public void test() {
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 100}, {11,22},{1,11},{2,12}}));
    }

}
