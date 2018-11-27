package leetcode;

import org.junit.Test;

public class p84_LargestRectangleinHistogram_这道题很好 {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int[] leftLessFrom = new int[heights.length];
        int[] rightLessFrom = new int[heights.length];
        leftLessFrom[0] = -1;
        rightLessFrom[heights.length - 1] = heights.length;

        int j;
        for (int i = 0; i < heights.length; i++) {
            j = i - 1;
            while (j >= 0 && heights[j] >= heights[i]) {
                j = leftLessFrom[j];
            }
            leftLessFrom[i] = j;
        }
        for (int i = heights.length - 1; i >= 0; i--) {
            j = i + 1;
            while (j < heights.length && heights[j] >= heights[i]) {
                j = rightLessFrom[j];
            }
            rightLessFrom[i] = j;
        }
        int max = Integer.MIN_VALUE;
        int area;
        for (int i = 0; i < heights.length; i++) {
            area = (rightLessFrom[i] - leftLessFrom[i] - 1) * heights[i];
            if (max < area) {
                max = area;
            }
        }
        return max;
    }

    @Test
    public void test() {

    }
}
