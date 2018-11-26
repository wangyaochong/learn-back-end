package leetcode;

import org.junit.Test;

public class p26_RemoveDuplicatesfromSortedArray {
    @Test
    public void test() {
        System.out.println(removeDuplicates(new int[]{1, 2, 2, 3, 4, 4, 5, 5, 5, 6}));
    }

    public int removeDuplicates(int[] nums) {
        int locMask = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i - locMask] = nums[i];
            while (i + 1 + count < nums.length && nums[i] == nums[i + 1 + count]) {
                count++;
            }
            locMask += count;
            i += count;
            count = 0;
        }
        return nums.length - locMask;
    }

    public int removeDuplicates2(int[] nums) {
        int sameCount=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i]){
                sameCount++;
            }else{
                nums[i-sameCount]=nums[i];
            }
        }
        return nums.length-sameCount;
    }

    //这代码真牛！充分利用排好序的属性！
    public int removeDuplicates3(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 1 || n > nums[i - 1]) {
                nums[i] = n;
                i++;
            }
        }
        return i;
    }
}
