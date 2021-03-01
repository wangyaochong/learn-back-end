package leetcode.byNumber;

import org.junit.Test;

public class p42_TrappingRainWater {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length + 1];
        int[] maxRight = new int[height.length + 1];

        for (int i = 0; i < height.length; i++) {
            maxLeft[i + 1] = Math.max(height[i], maxLeft[i]);
            maxRight[height.length - i - 1] = Math.max(height[height.length - i - 1], maxRight[height.length - i]);
        }

        int count = 0;
        for (int i = 0; i < height.length; i++) {
            int min = Math.min(maxLeft[i + 1], maxRight[i]);
            count += (min - height[i]);
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
