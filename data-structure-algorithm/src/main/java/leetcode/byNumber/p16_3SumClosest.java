package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;

public class p16_3SumClosest {
    @Test
    public void test() {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(result - target) > Math.abs(sum - target)) {
                    result = sum;
                }
                if (sum > target) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return result;
    }
}
