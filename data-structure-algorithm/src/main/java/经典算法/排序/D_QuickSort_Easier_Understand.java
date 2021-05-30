package 经典算法.排序;

import org.junit.Test;
import util.UtilArray;

/**
 * 冒泡排序的升级版
 */
public class D_QuickSort_Easier_Understand {

    @Test
    public void test() {
        int[] array = {1, 2, 3, 4, 2, 3, 5, 1, 2, 3, -1, 5, 8, 7};
        sort(array, 0, array.length - 1);
        UtilArray.display(array);
    }

    public void sort(int[] array, int i, int j) {
        if (i >= j) {
            return;
        }
        int splitLoc = bubbleTwoPart(array, i, j);
        sort(array, i, splitLoc - 1);
        sort(array, splitLoc + 1, j);
    }

    //部分冒泡，将大的数据冒泡到右侧
    public int bubbleTwoPart(int[] array, int i, int j) {
        int flag = array[i];//把flag作为冒泡的切分点
        while (i < j) {
            while (i < j && array[j] >= flag) j--;

            //如果没有找到需要交换的数，那么i=j，即时发生交换也没关系
            UtilArray.swap(array, i, j);

            while (i < j && array[i] <= flag) i++;

            //如果没有找到需要交换的数，那么i=j，即时发生交换也没关系
            UtilArray.swap(array, i, j);
        }
        return i;//返回切分好的位置
    }
}
