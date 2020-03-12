package 经典算法.动态规划;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 01背包，不能重复选取
 */
public class Bag01 {


    public int solve(int bagSize, List<Item> itemList) {
        int[][] dp = new int[bagSize + 1][itemList.size() + 1];
        for (int i = 1; i < bagSize + 1; i++) {
            for (int j = 0; j < itemList.size(); j++) {
                if (i - itemList.get(j).getWeight() >= 0) {
                    dp[i][j + 1] = Math.max(dp[i][j], dp[i - itemList.get(j).getWeight()][j] + itemList.get(j).getValue());
                } else {
                    dp[i][j + 1] = dp[i][j];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[bagSize][itemList.size()];
    }

    @Test
    public void test() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(5, 2));
        items.add(new Item(1, 2));
        items.add(new Item(4, 3));
        System.out.println(solve(6, items));
    }
}
