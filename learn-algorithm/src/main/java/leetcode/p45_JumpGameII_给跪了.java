package leetcode;

import org.junit.Test;

public class p45_JumpGameII_给跪了 {

    public int jump(int[] nums) {
        int curFarthest=0,curEnd=0,jump=0;
        for(int i=0;i<nums.length-1;i++){
            curFarthest=Math.max(curFarthest,i+nums[i]);
            if(i==curEnd){
                curEnd=curFarthest;
                jump++;
            }
        }
        return jump;
    }
    @Test
    public void test(){
        System.out.println(jump(new int[]{2,3,1,1,4,1,1,1,1,1,1,1}));
    }
}
