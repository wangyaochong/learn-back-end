package leetcode.byNumber;

import leetcode.base.definition.Point;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class p149_MaxPointsonaLineArr {

    public int maxPoints(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }
        int maxCount = 0;
        for (int i = 0; i < points.length; i++) {
            if (maxCount >= points.length - i) {
                break;
            }
            Map<BigDecimal, Integer> slopCache = new HashMap<>();
            int oneMaxCount = 0;
            int verticalCount = 1;
            for (int j = i + 1; j < points.length; j++) {
                int[] point1 = points[i];
                int[] point2 = points[j];
                if (point1[0] == point2[0]) {
                    verticalCount++;
                    if (oneMaxCount < verticalCount) {
                        oneMaxCount = verticalCount;
                    }
                } else {
                    BigDecimal slop = new BigDecimal((point2[1] - point1[1])).divide(new BigDecimal(point2[0] - point1[0]), 10, RoundingMode.HALF_UP);
                    Integer integer = slopCache.get(slop);
                    if (integer == null) {
                        integer = 1;
                    }
                    integer++;
                    slopCache.put(slop, integer);
                    if (oneMaxCount < integer) {
                        oneMaxCount = integer;
                    }
                }
            }
            if (maxCount < oneMaxCount) {
                maxCount = oneMaxCount;
            }
        }
        return maxCount;
    }

    @Test
    public void test() {
        System.out.println(maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        System.out.println(maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
    }


}
