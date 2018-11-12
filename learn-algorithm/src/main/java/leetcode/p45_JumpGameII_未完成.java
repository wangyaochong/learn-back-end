package leetcode;

import org.junit.Test;

public class p45_JumpGameII_未完成 {

    public int jump(int[] nums) {
        int[][] dp=new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                dp[i][j]=Integer.MAX_VALUE;
                if(nums[i]+i>=j){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=Math.min(dp[i][i+nums[i]]+dp[i+nums[i]][j],dp[i][j]);
                }
            }
        }
        return dp[0][nums.length-1];
    }
    @Test
    public void test(){
        System.out.println(jump(new int[]{2,3,1,1,4,1,1,1,1,1,1}));
    }
}
