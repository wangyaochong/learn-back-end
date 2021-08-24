package leetcode.byNumber;

import org.junit.Test;

public class p300_lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max=0;
        for (int j : dp) {
            if (max < j) {
                max = j;
            }
        }
        return max;
    }


    @Test
    public void test() {
        System.out.println(lengthOfLIS(new int[]{0, 1,2,3, 0, 4, 2, 3}));
        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
    }
}
