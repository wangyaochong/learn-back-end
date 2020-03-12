package 经典算法.排序;


import org.junit.Test;
import structure.heap.MaxHeap;

import java.util.Arrays;

/**
 * 主要思想是先构造大顶堆，然后取出堆顶，放到数组尾部未排序的位置，重复这个过程即可
 */
public class I_HeapSort {

    @Test
    public void test() {
//        int[] arr = new int[]{1, 3, 5, 6, 7, 2, 4, 1, 9, 11, 2, 8, 1, 110, 2};
        int[] arr = new int[]{1, 3, 5, 2, 1, 2, 1, 2};
        MaxHeap maxHeap = new MaxHeap();
        for (int i : arr) {
            maxHeap.insert(i);
        }
        System.out.println(Arrays.toString(maxHeap.getSortedData()));
    }
}
