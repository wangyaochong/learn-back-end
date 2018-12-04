package 经典算法.排序;

import org.junit.Test;
import util.UtilArray;

public class E_MergeSort {

    public void sort(int[] array) {
        merge(array, 0, array.length, new int[array.length]);
    }

    public void merge(int[] array, final int start, final int end, int[] tmpArr) {
        if (start + 1 >= end) {
            return;
        }
        final int mid = (start + end) / 2;
        merge(array, start, mid, tmpArr);
        merge(array, mid, end, tmpArr);
        int tmpStart = start;
        int tmp = mid;
        int count = 0;
        while (tmpStart < mid || tmp < end) {
            if (tmpStart >= mid || (tmp < end && array[tmpStart] > array[tmp])) {
                tmpArr[tmpStart + count] = array[tmp];
                tmp++;
                count++;
            } else {
                tmpArr[tmpStart + count] = array[tmpStart];
                tmpStart++;
            }
        }
        System.arraycopy(tmpArr, start, array, start, end - start);
    }

    @Test
    public void test() {
        int[] input = new int[]{1, 5, 2, 4, 3};
        sort(input);
        UtilArray.display(input);
    }
}
