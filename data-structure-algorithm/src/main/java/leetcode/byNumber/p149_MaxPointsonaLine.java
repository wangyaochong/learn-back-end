package leetcode.byNumber;

import leetcode.base.definition.Point;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class p149_MaxPointsonaLine {
    public int maxPoints(Point[] points) {
        int maxCount = 0;
        for (int i = 0; i < points.length; i++) {
            if (maxCount >= points.length - i) {
                break;
            }
            Map<Integer, Map<Integer, Integer>> cacheSlop = new HashMap<>();
            int one = 1;
            int sameCount = 0;
            int maxSlopCount = 1;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    sameCount++;
                } else if (points[i].x == points[j].x) {
                    one++;
                } else {
                    int slopY = (points[i].y - points[j].y);
                    int slopX = (points[i].x - points[j].x);
                    int gcd = gcd(slopX, slopY);
                    slopY /= gcd;
                    slopX /= gcd;

                    Map<Integer, Integer> integerIntegerMap = cacheSlop.get(slopY);
                    if (integerIntegerMap == null) {
                        cacheSlop.put(slopY, new HashMap<>());
                    }
                    Integer integer = cacheSlop.get(slopY).get(slopX);
                    if (integer == null) {
                        cacheSlop.get(slopY).put(slopX, 2);
                        if (maxSlopCount < 2) {
                            maxSlopCount = 2;
                        }
                    } else {
                        cacheSlop.get(slopY).put(slopX, integer + 1);
                        if (maxSlopCount < integer + 1) {
                            maxSlopCount = integer + 1;
                        }
                    }
                }
            }
            if (maxCount < sameCount + maxSlopCount) {
                maxCount = sameCount + maxSlopCount;
            }
            if (maxCount < one) {
                maxCount = one;
            }
        }
        return maxCount;
    }

    @Test
    public void test() {
        System.out.println(maxPoints(new Point[]{new Point(0, 0), new Point(94911151, 94911150), new Point(94911152, 94911151)}));
    }


    public int gcd(int x, int y) {
        int tmp;
        while (y != 0) {
            tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }

    @Test
    public void testGcd() {
        System.out.println(gcd(3, 8));
    }

}
