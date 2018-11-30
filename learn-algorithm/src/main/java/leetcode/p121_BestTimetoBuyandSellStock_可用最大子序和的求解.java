package leetcode;

import org.junit.Test;

public class p121_BestTimetoBuyandSellStock_可用最大子序和的求解 {


    public int maxProfit(int[] prices) {
        int[] max = new int[prices.length + 1];
        int[] min = new int[prices.length + 1];
        min[0] = Integer.MAX_VALUE;

        for (int i = prices.length - 1; i >= 0; i--) {
            max[i] = Math.max(prices[i], max[i + 1]);
        }
        for (int i = 0; i < prices.length; i++) {
            min[i + 1] = Math.min(prices[i], min[i]);
        }
        int maxNum = 0;
        for (int i = 0; i < prices.length; i++) {
            if (maxNum < max[i] - min[i + 1]) {
                maxNum = max[i] - min[i + 1];
            }
        }
        return maxNum;
    }

    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
