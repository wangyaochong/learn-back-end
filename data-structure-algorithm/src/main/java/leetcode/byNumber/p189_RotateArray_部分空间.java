package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;

public class p189_RotateArray_部分空间 {


    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] ints = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        System.arraycopy(nums, 0, nums, k, nums.length - k);//这两个array可以修改成for循环
        System.arraycopy(ints, 0, nums, 0, ints.length);
    }


    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
