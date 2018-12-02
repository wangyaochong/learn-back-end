package leetcode.byNumber;

import org.junit.Test;

public class p96_UniqueBinarySearchTrees_dp法 {


    public int numTrees(int n) {
        int[] dp = new int[n + 1];    //dp[n]代表数量为n的节点有多少种不同的排序方式，dp[0]表示只有null
        dp[0] = dp[1] = 1;
        for (int right = 2; right <= n; right++) {
            for (int left = 1; left <= right; left++) {
                dp[right] += (dp[left - 1] * dp[right - left]);   //left-1表示从[1,left)的节点，right-left表示从(left，right]的节点
            }
        }

        return dp[n];
    }

    @Test
    public void test() {
        System.out.println(numTrees(1));
        System.out.println(numTrees(2));
        System.out.println(numTrees(3));
        System.out.println(numTrees(4));
    }
}
