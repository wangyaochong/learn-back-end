package leetcode.byNumber;

public class p912_sortArray {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = partition(nums, start, end);
        quickSort(nums, start, i - 1);
        quickSort(nums, i + 1, end);
    }

    public int partition(int[] nums, int start, int end) {
        int flag = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= flag) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= flag) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = flag;
        return start;
    }
}
