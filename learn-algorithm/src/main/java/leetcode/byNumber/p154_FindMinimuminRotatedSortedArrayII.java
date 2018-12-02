package leetcode.byNumber;

import org.junit.Test;

public class p154_FindMinimuminRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (end >= 0 && nums[end] == nums[0]) {
            end--;
        }
        if (end < 0) {
            return nums[0];
        }
        if (nums[end] >= nums[0]) {//没被旋转
            return nums[0];
        }
        int mid;
        while (nums[start] > nums[end]) {
            mid = (start + end) / 2;
            if (nums[mid] >= nums[start]) {
                start = mid + 1;
            } else if (nums[mid] < nums[start]) {
                end = mid - 1;
                if (nums[end] >= nums[start]) {
                    return nums[end + 1];
                }
            }
        }
        return nums[start];
    }

    @Test
    public void test() {
        System.out.println(findMin(new int[]{3, 1, 3}));
    }
}
