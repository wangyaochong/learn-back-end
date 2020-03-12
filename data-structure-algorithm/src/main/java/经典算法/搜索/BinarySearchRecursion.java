package 经典算法.搜索;

import org.junit.Test;

public class BinarySearchRecursion {
    @Test
    public void test() {
        int[] list = {1, 2, 4, 5, 6, 7, 9};
        System.out.println(search(list, 4, 0, list.length - 1));
        int[] list1 = {1};
        System.out.println(search(list1, 1, 0, list1.length - 1));
    }

    public int search(int[] list, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (list[mid] > target) {
            return search(list, target, start, mid - 1);
        } else if (list[mid] < target) {
            return search(list, target, mid + 1, end);
        } else {
            return mid;
        }
    }
}
