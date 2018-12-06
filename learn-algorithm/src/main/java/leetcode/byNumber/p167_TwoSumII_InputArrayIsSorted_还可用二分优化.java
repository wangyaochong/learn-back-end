package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;

public class p167_TwoSumII_InputArrayIsSorted_还可用二分优化 {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (start < end && numbers[end] + numbers[start] > target) {
                end--;
            }
            if (start < end && numbers[end] + numbers[start] < target) {
                start++;
            }
            if (start < end && numbers[end] + numbers[start] == target) {
                return new int[]{start + 1, end + 1};
            }
        }
        return null;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
