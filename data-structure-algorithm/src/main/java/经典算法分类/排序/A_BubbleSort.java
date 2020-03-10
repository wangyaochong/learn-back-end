package 经典算法分类.排序;

import org.junit.Test;
import util.UtilArray;

public class A_BubbleSort {

    @Test
    public void test() {
        int[] array = {1, 2, 3, 4, 2, 3, 5};
        sort(array);
        UtilArray.display(array);
    }

    public void sort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    UtilArray.swap(array, j - 1, j);
                }
            }
        }
    }
}
