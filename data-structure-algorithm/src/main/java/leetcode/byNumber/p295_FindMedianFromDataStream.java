package leetcode.byNumber;

import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class p295_FindMedianFromDataStream {
    /**
     * initialize your data structure here.
     */
    private Map<Integer, Integer> numCount = new TreeMap<>();
    private int totalCount = 0;

    public void addNum(int num) {
        numCount.merge(num, 1, (a, b) -> a + b);
        totalCount++;
    }

    public double findMedian() {
        Iterator<Map.Entry<Integer, Integer>> iterator = numCount.entrySet().iterator();
        int curCount = 0;
        int lastCount = 0;
        int lastVal = 0;
        int curVal = 0;
        while (iterator.hasNext() && curCount <= totalCount / 2) {
            Map.Entry<Integer, Integer> next = iterator.next();
            lastVal = curVal;
            lastCount = curCount;
            curCount += next.getValue();
            curVal = next.getKey();
        }
        if (lastCount == totalCount / 2 && totalCount % 2 == 0) {
            return (double) (lastVal + curVal) / 2;
        } else {
            return curVal;
        }
    }

    @Test
    public void test() {
        addNum(1);
        addNum(2);
        addNum(3);
        addNum(4);
        addNum(4);
        addNum(5);
        addNum(5);
        System.out.println(findMedian());
    }
}
