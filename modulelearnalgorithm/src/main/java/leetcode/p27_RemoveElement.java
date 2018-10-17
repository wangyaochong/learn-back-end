package leetcode;

import org.junit.Test;

public class p27_RemoveElement {
    @Test
    public void test(){
        System.out.println(removeElement(new int[]{1,2,3,4,3},3));
    }

    public int removeElement(int[] nums, int val) {
        int removeCount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                removeCount++;
            }else{
                nums[i-removeCount]=nums[i];
            }
        }
        return nums.length-removeCount;
    }
}
