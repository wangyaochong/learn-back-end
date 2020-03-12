package 经典算法.搜索;


import org.junit.Test;

/**
 * 插值查找，是对二分查找的改进
 */
public class InsertSearch {

    public int search(int[] list, int target) {
        int low = 0;
        int high = list.length - 1;
        int mid;
        while (low <= high) {
            //主要就是这里是自适应的
            if (low == high) {
                return list[low] == target ? low : -1;
            }
            mid = low + (high - low) * (target - list[low]) / (list[high] - list[low]);
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

    @Test
    public void test() {
        System.out.println(search(new int[]{1, 2, 4, 5, 6, 7, 9}, 4));
        System.out.println(search(new int[]{1}, 1));
    }
}
