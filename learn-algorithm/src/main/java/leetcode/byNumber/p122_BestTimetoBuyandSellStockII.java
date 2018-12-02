package leetcode.byNumber;

import org.junit.Test;

public class p122_BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int i = prices.length - 1;
        int sum = 0;
        while (i >= 1) {
            while (i >= 1 && prices[i] <= prices[i - 1]) {
                i--;
            }
            if (i >= 1) {
                sum += prices[i] - prices[i - 1];
            }
            i--;
        }
        return sum;
    }

    public int maxProfitGreedy(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                sum += prices[i + 1] - prices[i];
            }
        }
        return sum;
    }

    @Test
    public void test() {
        System.out.println(maxProfitGreedy(new int[]{1, 2, 3, 4, 5}));
    }
}
