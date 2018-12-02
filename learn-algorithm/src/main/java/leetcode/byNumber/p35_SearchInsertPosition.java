package leetcode.byNumber;

import org.junit.Test;

public class p35_SearchInsertPosition {

    @Test
    public void test(){
        System.out.println(searchInsert(new int[]{1,2,4},0));
    }
    public int searchInsert(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int mid;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]<target){
                low=mid+1;
            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                return mid;
            }
        }
        return low;
    }
}
