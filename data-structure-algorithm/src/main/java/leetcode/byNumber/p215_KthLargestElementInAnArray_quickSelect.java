package leetcode.byNumber;

import org.junit.Test;
import util.UtilArray;

import java.util.Arrays;
import java.util.Random;

public class p215_KthLargestElementInAnArray_quickSelect {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return sort(nums, 0, nums.length - 1, nums.length - k);
    }

    public int sort(int[] arr, int start, int end, int index) {
        int loc = partitionBetter(arr, start, end);
        if (loc == index) {
            return arr[loc];
        }
        return index < loc ? sort(arr, start, loc - 1, index) : sort(arr, loc + 1, end, index);
    }

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public int partitionBetter(int[] arr, int start, int end) {
        int loc = random.nextInt(end - start + 1) + start;
        swap(arr, start, loc);
        int tmp = arr[start];
        while (start < end) {
            while (start < end && arr[end] >= tmp) end--;
            arr[start] = arr[end];
            while (start < end && arr[start] <= tmp) start++;
            arr[end] = arr[start];
        }
        arr[start] = tmp;
        return start;
    }

    public int partition(int[] arr, int start, int end) {
        int loc = random.nextInt(end - start + 1) + start;
        UtilArray.swap(arr, start, loc);
        loc = start;
        while (start < end) {
            while (start < end && arr[end] >= arr[loc]) end--;
            UtilArray.swap(arr, end, loc);
            loc = end;
            while (start < end && arr[start] <= arr[loc]) start++;
            UtilArray.swap(arr, start, loc);
            loc = start;
        }
        return loc;
    }


    @Test
    public void test() {
        int[] nums = {1, 2, 111, 3, 45, 4, 11, 5, 6};
        System.out.println("k=2," + findKthLargest(nums, 2));
        System.out.println("k=7," + findKthLargest(nums, 7));
        System.out.println("k=3," + findKthLargest(nums, 3));

        Arrays.sort(nums);
        UtilArray.display(nums);

    }
}
