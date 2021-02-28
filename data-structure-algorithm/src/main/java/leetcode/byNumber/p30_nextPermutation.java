package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;

public class p30_nextPermutation {
    public void nextPermutation(int[] nums) {
        int reverseLoc=nums.length-2;
        while(reverseLoc>=0&&nums[reverseLoc]>=nums[reverseLoc+1]){
            reverseLoc--;
        }
        if(reverseLoc<0){//没有更大的了，都是逆序
            Arrays.sort(nums,reverseLoc+1,nums.length);
            return ;
        }
        int tempLoc=nums.length-1;
        while(nums[reverseLoc]>=nums[tempLoc]){//（这段代码可以使用二分查找加速）
            tempLoc--;
        }
        swap(nums, tempLoc, reverseLoc);
        Arrays.sort(nums,reverseLoc+1,nums.length);
    }
    public void swap(int[]nums,int a,int b){
        int tmp=nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }

    @Test
    public void test(){
//        int[] nums = {1, 4, 5, 3, 2};
        int[] nums = {1,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
