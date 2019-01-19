package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class p239_SlidingWindowMaximum_比较慢的一种解法 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int[] result = new int[nums.length - k + 1];
        for (int j = 0; j < k; j++) {
            queue.add(nums[j]);
        }
        for (int i = 0; i < nums.length - k + 1; i++) {
            if (queue.size() < k) {
                queue.add(nums[i + k - 1]);
            }
            result[i] = queue.peek();
            queue.remove(nums[i]);
        }
        return result;
    }

    @Test
    public void testResult() {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }


    @Test
    public void testQueue() {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.add(1);
        queue.add(2);
        queue.add(-1);
        System.out.println(queue.peek());
    }
}
