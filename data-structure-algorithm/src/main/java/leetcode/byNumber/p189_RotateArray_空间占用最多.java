package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;

public class p189_RotateArray_空间占用最多 {


    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int i = 0;
        int[] result = new int[nums.length];
        while (i < nums.length) {
            result[(i + k) % nums.length] = nums[i];
            i++;
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
    }


    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
