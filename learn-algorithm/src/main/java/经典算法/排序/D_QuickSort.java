package 经典算法.排序;

import org.junit.Test;
import util.UtilArray;

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
        int flag = array[i];
        while (i < j) {
            while (i < j && array[j] >= flag) {
                j--;
            }
            array[i] = array[j];
            while (i < j && array[i] <= flag) {
                i++;
            }
            array[j] = array[i];
        }
        array[i] = flag;
        return i;
    }
}
