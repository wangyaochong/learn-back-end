package leetcode.byNumber;

import org.junit.Test;

public class p153_FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {

        if (nums[nums.length - 1] >= nums[0]) {//没被旋转
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (nums[start] > nums[end]) {
            mid = (start + end) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid - 1;
                if (nums[end] >= nums[start]) {
                    return nums[end + 1];
                }
            } else {
                return nums[mid];
            }
        }
        return nums[start];
    }

    @Test
    public void test() {
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

}
