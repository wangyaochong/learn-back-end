package 经典算法分类.排序;

import org.junit.Test;
import util.UtilArray;

public class C_SelectSort {
    @Test
    public void test() {
        int[] array = {1, 2, 3, 4, 2, 3, 5};
        sort(array);
        UtilArray.display(array);
    }

    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minLoc = i;
            for (int j = i; j < array.length; j++) {
                if (array[minLoc] > array[j]) {
                    minLoc = j;//找到最小的坐标
                }
            }
            UtilArray.swap(array, minLoc, i);//最小的与第一个没有排序好的数交换
        }
    }
}
