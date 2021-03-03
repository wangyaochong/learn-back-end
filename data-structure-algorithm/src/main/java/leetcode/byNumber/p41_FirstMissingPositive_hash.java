package leetcode.byNumber;

import org.junit.Test;


public class p41_FirstMissingPositive_hash {

    @Test
    public void test() {
        System.out.println((int) Math.pow(2, 31));
        System.out.println((int) Math.pow(2, 32));
        System.out.println((int) -Math.pow(2, 32));

//        System.out.println(firstMissingPositive(new int[]{1,2,3,5}));
//        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{1, 1}));
    }

    // 注意，这道题一定有没有出现的，所以没有出现的数，一定是小于等于2的31次方的

    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = nums.length + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            if (abs <= nums.length && nums[abs - 1] > 0) {
                nums[abs - 1] = -nums[abs - 1];
            }

        }
        int i = 0;
        while (i < nums.length && nums[i] < 0) {
            i++;
        }
        return i + 1;
    }

}
