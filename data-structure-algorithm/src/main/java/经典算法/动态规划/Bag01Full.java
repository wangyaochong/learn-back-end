package 经典算法.动态规划;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 完全背包，可以重复选取
 */
public class Bag01Full {

    public int solve2(int bagSize, List<Item> itemList) {
        int[][] dp = new int[bagSize + 1][itemList.size() + 1];
        for (int i = 1; i < bagSize + 1; i++) {
            for (int j = 0; j < itemList.size(); j++) {
                if (i - itemList.get(j).getWeight() >= 0) {
                    //完全背包j+1
                    dp[i][j + 1] = Math.max(dp[i][j], dp[i - itemList.get(j).getWeight()][j + 1] + itemList.get(j).getValue());
                } else {
                    dp[i][j + 1] = dp[i][j];
                }
            }
        }
        return dp[bagSize][itemList.size()];
    }

    public int solve(int bagSize, List<Item> itemList) {
        int[] tmp = new int[bagSize + 1];
        for (int j = 0; j < itemList.size(); j++) {
            for (int i = 1; i <= bagSize; i++) {
                if (i - itemList.get(j).getWeight() >= 0) {
                    tmp[i] = Math.max(tmp[i], Math.max(tmp[i - 1], tmp[i - itemList.get(j).getWeight()] + itemList.get(j).getValue()));
                } else {
                    tmp[i] = Math.max(tmp[i - 1], tmp[i]);
                }
            }
        }
        return tmp[bagSize];
    }

    @Test
    public void test() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(5, 2));
        items.add(new Item(1, 2));
        items.add(new Item(4, 3));
        System.out.println(solve(6, items));
        System.out.println(solve2(6, items));
    }
}
