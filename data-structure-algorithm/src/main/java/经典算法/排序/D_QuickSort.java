package 经典算法.排序;

import org.junit.Test;
import util.UtilArray;

import java.util.Arrays;

/**
 * 冒泡排序的升级版
 */
public class D_QuickSort {

    @Test
    public void test() {
        int[] array = {1, 2, 3, 4, 2, 3, 5};
        sort(array, 0, array.length - 1);
        UtilArray.display(array);
    }

    public void sort(int[] array, int i, int j) {
        if (i >= j) {
            return;
        }
        int mid = partition2(array, i, j);
        sort(array, i, mid - 1);
        sort(array, mid + 1, j);
    }

    @Test
    public void testPartition2() {
        int[] arr = {5, 9, 2, 6, 8, 3};
        partition2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public int partition2(int[] arr, int start, int end) {
        int pivot = arr[start];
        int smallIndex = start;
        for (int small = start + 1; small <= end; small++) {
            if (arr[small] < pivot) {
                smallIndex++;
                UtilArray.swap(arr, small, smallIndex);
            }
        }
        /*以上代码的完整执行过程
 初始数据：  [5,9,2,6,8,3]
         * [5,2,9,6,8,3]
         * [5,2,3,6,8,9]
         */
        UtilArray.swap(arr, smallIndex, start);
        /* 交换以后得到最终结果
            [3,2,5,6,8,9]
         */
        return smallIndex;
    }

    public int partition(int[] array, int i, int j) {
        int flag = array[i];//把flag作为冒泡的切分点
        while (i < j) {
            while (i < j && array[j] >= flag) {//从右往左，扫描比flag小的数
                j--;
            }
            array[i] = array[j]; //将这个小的值放到左边
            while (i < j && array[i] <= flag) {//从左往右，扫描比flag大的数
                i++;
            }
            array[j] = array[i];//将这个大的值放到右边
        }
        array[i] = flag;
        return i;
    }
}
