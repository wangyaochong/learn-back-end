package 经典算法分类.搜索;

import org.junit.Test;

public class BinarySearch {
    @Test
    public void test() {
        System.out.println(search(new int[]{1, 2, 4, 5, 6, 7, 9}, 4));
        System.out.println(search(new int[]{1}, 1));
    }

    public int search(int[] list, int target) {
        int low = 0;
        int high = list.length - 1;
        int mid;
        while (low <= high) {
            //下面两种表达式是等价的
            mid = (low + high) / 2;
            mid = low + (high - low) / 2;
            if (list[mid] < target) {
                low = mid + 1;
            } else if (list[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
