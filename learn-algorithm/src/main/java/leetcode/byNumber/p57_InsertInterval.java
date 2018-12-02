package leetcode.byNumber;

import leetcode.base.definition.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p57_InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            return Collections.singletonList(newInterval);
        }

        int j = 0;
        while (j < intervals.size() && intervals.get(j).start < newInterval.start) {
            j++;
        }
        intervals.add(j, newInterval);

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
}
