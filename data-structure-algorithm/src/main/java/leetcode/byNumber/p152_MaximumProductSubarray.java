package leetcode.byNumber;

public class p152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int current = 1, currentReverse = 1, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            current = current * nums[i];//just multiply
            currentReverse = currentReverse * nums[nums.length - 1 - i];
            if (max < current) max = current;
            if (current == 0) current = 1;//if 0，start new sub array
            if (max < currentReverse) max = currentReverse;
            if (currentReverse == 0) currentReverse = 1; //if 0，start new sub array
        }
        return max;
    }
}
