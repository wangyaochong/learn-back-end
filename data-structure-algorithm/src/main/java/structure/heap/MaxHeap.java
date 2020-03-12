package structure.heap;

import java.util.Arrays;

public class MaxHeap {
    private int[] arr;
    private int curSize = 0;

    public MaxHeap() {
        arr = new int[10];
        Arrays.fill(arr, Integer.MIN_VALUE);
    }

    public void insert(int v) {
        //如果已经满了，就扩容
        if (curSize == arr.length) {
            int[] newData = new int[arr.length * 2];
            Arrays.fill(newData, Integer.MIN_VALUE);
            System.arraycopy(arr, 0, newData, 0, arr.length);
            arr = newData;
        }
        arr[curSize] = v;
        siftUp(curSize);
        curSize++;
    }

    public int[] getSortedData() {
        int[] cache = new int[arr.length];
        int[] result = new int[curSize];
        System.arraycopy(arr, 0, cache, 0, arr.length);
        while (curSize > 0) {
            swap(0, curSize - 1);
            curSize--;
            siftDown(0);
        }
        System.arraycopy(arr, 0, result, 0, result.length);
        System.arraycopy(cache, 0, arr, 0, cache.length);
        return result;
    }

    public void siftDown(int loc) {
        int maxLoc = -1;
        int leftNodeLoc = loc * 2 + 1;
        int rightNodeLoc = loc * 2 + 2;

        //如果loc位置和右子节点都小于左子节点
        if (leftNodeLoc < curSize && arr[loc] < arr[leftNodeLoc] && arr[rightNodeLoc] <= arr[leftNodeLoc]) {
            maxLoc = leftNodeLoc;
        }
        //如果loc位置和左子节点都小于右子节点
        if (rightNodeLoc < curSize && arr[loc] < arr[rightNodeLoc] && arr[leftNodeLoc] < arr[rightNodeLoc]) {
            maxLoc = rightNodeLoc;
        }
        //找出下沉时哪个子节点更大
        if (maxLoc != -1) {
            swap(loc, maxLoc);
            siftDown(maxLoc);
        }
    }

    public void siftUp(int loc) {
        if (loc < 1) return;
        if (arr[loc] > arr[(loc - 1) / 2]) {
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
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);
        maxHeap.insert(4);
        maxHeap.insert(1);
        maxHeap.insert(18);
        maxHeap.insert(5);
        System.out.println(Arrays.toString(maxHeap.arr));
        System.out.println(Arrays.toString(maxHeap.getSortedData()));
    }
}
