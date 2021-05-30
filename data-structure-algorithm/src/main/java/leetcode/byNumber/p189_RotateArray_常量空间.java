package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;

public class p189_RotateArray_常量空间 {


    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            shift(nums);
        }
    }

    public void shift(int[] nums) {
        int tmp = nums[nums.length - 1];
        int i = nums.length - 1;
        for (; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[i] = tmp;
    }


    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
