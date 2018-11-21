package leetcode;

import leetcode.base.Interval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class p56_MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return intervals;
        }
        intervals.sort(Comparator.comparing(o -> o.start));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> resultList = new ArrayList<>();
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start <= end) {
                end = Math.max(interval.end, end);
            } else {
                resultList.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        resultList.add(new Interval(start, end));
        return resultList;
    }

    @Test
    public void test() {
        System.out.println(merge(new ArrayList<>(Arrays.asList(new Interval(1, 3), new Interval(2, 3), new Interval(4, 6), new Interval(5, 7)))));
    }
}
