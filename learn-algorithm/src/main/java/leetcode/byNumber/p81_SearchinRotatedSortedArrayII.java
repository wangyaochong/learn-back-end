package leetcode.byNumber;

import org.junit.Test;

public class p81_SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        if (nums[0] == target) {
            return true;
        }
        int low = 0;
        int high = nums.length - 1;
        while (high >= 0 && nums[high] == nums[0]) {//如果说重复数字在首尾，则无法判断target和nums[mid]是否在同一边，所以需要去除首尾重复的值
            high--;
        }
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] < nums[0] != target < nums[0]) {
                if (target >= nums[0]) {
                    nums[mid] = Integer.MAX_VALUE;
                } else {
                    nums[mid] = Integer.MIN_VALUE;
                }
            }
            if (target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(search(new int[]{1, 3, 1, 1, 1}, 3));
    }
}
