package leetcode.byNumber;

import org.junit.Test;

public class p162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
                if (start + 1 < nums.length && nums[start] > nums[start + 1]) {
                    return start;
                }
            } else if (nums[mid] >= nums[mid + 1]) {
                end = mid - 1;
                if (end >= 0 && nums[end] < nums[end + 1]) {
                    return end + 1;
                }
            }
        }

        return start;
    }

    @Test
    public void test() {
        System.out.println(findPeakElement(new int[]{2, 1}));
    }

}
