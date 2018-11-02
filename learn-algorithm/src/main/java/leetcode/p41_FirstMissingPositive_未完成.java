package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class p41_FirstMissingPositive_未完成 {
    public int firstMissingPositive(int[] nums) {
        int curSize=1;
        for(int i=1;i<nums.length;i++){
            int flag=nums[i];
            if(flag<=0){
                continue;
            }
            int subLoc=curSize-1;
            while(subLoc-1>=0&&nums[subLoc-1]>flag){
                nums[subLoc]=nums[subLoc-1];
                subLoc--;
            }
            nums[subLoc]=flag;
            if(subLoc+1<nums.length&&nums[subLoc]!=nums[subLoc+1]){
                curSize++;
            }
        }
        for(int i:nums){
            System.out.println(i);
        }
        return 1;
    }

    @Test
    public void test() {
        int i = firstMissingPositive(new int[]{0,2,2,1,1});
        System.out.println("-----");
    }
}
