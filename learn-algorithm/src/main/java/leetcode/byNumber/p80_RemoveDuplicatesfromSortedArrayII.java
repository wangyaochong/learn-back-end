package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;

public class p80_RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i] = n;
                i++;
            }
        }

        return i;
    }

    @Test
    public void test() {
        int[] input = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2, 3};
//        int[] input = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(input));
        System.out.println(Arrays.toString(input));

    }

}
