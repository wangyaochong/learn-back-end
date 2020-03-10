package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;

public class p215_KthLargestElementInAnArray {

    static public class MinHeapFixSize {

        private int[] arr;
        int curSize = 0;

        public MinHeapFixSize(int size) {
            arr = new int[size];
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        public void insert(int v) {
            if (curSize < arr.length) {
                arr[curSize] = v;
                siftUp(curSize);
                curSize++;
                return;
            }
            if (curSize == arr.length && v > arr[0]) {
                arr[0] = v;
                siftDown(0);
            }
        }

        public void siftDown(int loc) {
            if (loc * 2 + 1 >= arr.length) {
                return;
            }
            int nextMinLoc = loc * 2 + 1;
            if (nextMinLoc + 1 < arr.length && arr[nextMinLoc] > arr[nextMinLoc + 1]) {
                nextMinLoc++;
            }
            if (arr[loc] > arr[nextMinLoc]) {
                swap(loc, nextMinLoc);
                siftDown(nextMinLoc);
            }
        }

        public void siftUp(int loc) {
            if (loc < 1) {
                return;
            }
            if (arr[loc] < arr[(loc - 1) / 2]) {
                swap(loc, (loc - 1) / 2);
                siftUp((loc - 1) / 2);
            }
        }

        public void swap(int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        public int getTop() {
            return arr[0];
        }
    }


    public int findKthLargest(int[] nums, int k) {
        MinHeapFixSize minHeapFixSize = new MinHeapFixSize(k);
        for (int num : nums) {
            minHeapFixSize.insert(num);
        }
        return minHeapFixSize.getTop();
    }

    @Test
    public void test() {
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 2));
    }
}
