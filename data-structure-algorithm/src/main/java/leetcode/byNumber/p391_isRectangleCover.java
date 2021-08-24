package leetcode.byNumber;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class p391_isRectangleCover {
    @Test
    public void test() {
//        System.out.println(isRectangleCover(new int[][]{
//                {1, 1, 3, 3},
//                {3, 1, 4, 2},
//                {3, 2, 4, 4},
//                {1, 3, 2, 4},
//                {2, 3, 3, 4}}));
        System.out.println(isRectangleCover(new int[][]{{0, 0, 4, 1},
                {7, 0, 8, 2}, {6, 2, 8, 3}, {5, 1, 6, 3},
                {4, 0, 5, 1}, {6, 0, 7, 2},
                {4, 2, 5, 3}, {2, 1, 4, 3}, {0, 1, 2, 2}, {0, 2, 2, 3}, {4, 1, 5, 2}, {5, 0, 6, 1}}));
    }

    public boolean isRectangleCover(int[][] rectangles) {
        Integer X2 = Integer.MIN_VALUE;
        Integer X1 = Integer.MAX_VALUE;
        Integer Y2 = Integer.MIN_VALUE;
        Integer Y1 = Integer.MAX_VALUE;

        Set<String> cache = new HashSet<>();
        Integer areaSum = 0;
        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0];
            int y1 = rectangle[1];
            int x2 = rectangle[2];
            int y2 = rectangle[3];
            areaSum += Math.abs(x1 - x2) * Math.abs(y1 - y2);
            X1 = Integer.min(X1, x1);
            Y1 = Integer.min(Y1, y1);
            X2 = Integer.max(X2, x2);
            Y2 = Integer.max(Y2, y2);
            String[] locs = new String[]{x1 + "," + y1, x1 + "," + y2, x2 + "," + y1, x2 + "," + y2};
            for (String oneLoc : locs) {
                if (!cache.contains(oneLoc)) {
                    cache.add(oneLoc);
                } else {
                    cache.remove(oneLoc);
                }
            }
        }
        if (!areaSum.equals((X2 - X1) * (Y2 - Y1))) {
            return false;
        }
        if (cache.size() != 4) {
            return false;
        } else {
            return cache.contains(X1 + "," + Y1)
                    && cache.contains(X1 + "," + Y2)
                    && cache.contains(X2 + "," + Y1)
                    && cache.contains(X2 + "," + Y2);
        }
    }

}
