package leetcode.byNumber;

import org.junit.Test;
import util.UtilArray;

public class p34_FindFirstandLastPositionofElementinSortedArray {
    @Test
    public void test(){
        int[] ints = searchRange(new int[]{1, 2, 3, 3,3}, 3);
        int[] ints2 = searchRange(new int[]{3, 3, 3, 3,2}, 3);
        int[] ints3 = searchRange(new int[]{1, 3, 3, 3,2}, 3);
        UtilArray.display(ints);
        UtilArray.display(ints2);
        UtilArray.display(ints3);
    }
    public int[] searchRange(int[] nums, int target) {

        int[] result=new int[2];
        result[0]=-1;
        result[1]=-1;
        if(nums==null||nums.length==0){
            return result;
        }
        int low=0;
        int high=nums.length-1;
        while(low<high){
            int mid= (low+high)/2;
            if(nums[mid]<target){
                low=mid+1;
            }else {
                high=mid;
            }
        }
        if(nums[low]==target){
            result[0]=low;
        }else{
            return result;
        }
        high=nums.length-1;
        while(low<high){
            int mid=(low+high+1)/2;
            if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid;
            }
        }
        result[1]=high;
        return result;
    }


}
