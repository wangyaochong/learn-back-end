package 经典算法分类.排序;

import org.junit.Test;
import util.UtilArray;

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
        int mid = partition(array, i, j);
        sort(array, i, mid - 1);
        sort(array, mid + 1, j);
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
