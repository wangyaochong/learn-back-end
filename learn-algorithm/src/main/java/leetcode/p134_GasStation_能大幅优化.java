package leetcode;

import org.junit.Test;

public class p134_GasStation_能大幅优化 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] dp = new int[gas.length];
        int sumGas = 0;
        int sumCost = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
        }
        if (sumGas < sumCost) {
            return -1;
        }
        int len = gas.length;
        int maxLoc = 0;
        for (int i = gas.length * 2 - 1; i >= 0; i--) {
            int diff = gas[i % len] - cost[i % len];
            if (diff + dp[(i + 1 + len) % len] >= 0) {
                dp[i % len] = dp[(i + 1 + len) % len] + diff;
                if (dp[maxLoc] < dp[i % len]) {
                    maxLoc = i % len;
                }
            } else {
                dp[i % len] = 0;
            }
        }
        return maxLoc;
    }

    @Test
    public void test() {
        System.out.println(canCompleteCircuit(new int[]{5, 8, 2, 8}, new int[]{6, 5, 6, 6}));
    }
}
