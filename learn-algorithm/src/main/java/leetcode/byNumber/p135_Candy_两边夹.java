package leetcode.byNumber;

import org.junit.Test;

public class p135_Candy_两边夹 {
    public int candy(int[] ratings) {
        int[] dp = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                dp[i] = Math.max(dp[i + 1] + 1, dp[i]);
            }
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += dp[i];
        }
        return sum;
    }

    @Test
    public void test() {
        System.out.println(candy(new int[]{1, 2, 3, 3, 2, 1, 2}));
//        System.out.println(candy(new int[]{1, 2, 2, 3}));
//        System.out.println(candy(new int[]{1, 2, 2, 2, 1}));
    }
}
