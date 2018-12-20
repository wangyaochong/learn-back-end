package structure.heap;

import java.util.Arrays;

/**
 * 固定大小的最小堆
 */
public class MinHeapFixSize {


    private int[] arr;
    private int curSize = 0;

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


    public static void main(String[] args) {
        MinHeapFixSize minHeapFixSize = new MinHeapFixSize(3);
        minHeapFixSize.insert(1);
        minHeapFixSize.insert(2);
        minHeapFixSize.insert(3);
        minHeapFixSize.insert(4);
        minHeapFixSize.insert(5);
        minHeapFixSize.insert(6);
        System.out.println(minHeapFixSize.getTop());
    }


}
