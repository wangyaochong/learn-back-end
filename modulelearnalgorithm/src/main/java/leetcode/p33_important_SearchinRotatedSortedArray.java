package leetcode;

import org.junit.Test;

public class p33_important_SearchinRotatedSortedArray {
    @Test
    public void test(){
        System.out.println(search(new int[]{5,1,3}, 5));
    }

    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int mid;
        int compareNum=0;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]<nums[0] == target<nums[0]){
                compareNum=nums[mid];
            }else{
                if(target>=nums[0]){
                    compareNum=Integer.MAX_VALUE;
                }else{
                    compareNum=Integer.MIN_VALUE;
                }
            }
            if(target>compareNum){
                low=mid+1;
            }else if(target<compareNum){
                high=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
