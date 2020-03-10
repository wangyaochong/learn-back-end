package leetcode.byNumber;

public class p303_RangeSumQueryImmutable {

    int[] sum;
    int[] nums;

    public p303_RangeSumQueryImmutable(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        this.nums = nums;
        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j] - sum[i] + nums[i];
    }
}
