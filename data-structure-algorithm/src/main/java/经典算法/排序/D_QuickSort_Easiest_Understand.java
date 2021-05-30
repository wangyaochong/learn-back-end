package 经典算法.排序;

import org.junit.Test;
import util.UtilArray;

/**
 * 冒泡排序的升级版
 */
public class D_QuickSort_Easiest_Understand {

     public void sort(int[] array, int i, int j) {
        if(i>=j){
            return;
        }
        int mid = partition(array, i, j);
        sort(array, i, mid - 1);
        sort(array, mid + 1, j);
    }

    public int partition(int[] array, int i, int j) {//这个是最容易懂的版本
        int loc = i;
        while (i < j) {
            while (i < j && array[j] >= array[loc]) j--;
            UtilArray.swap(array, loc, j);
            loc = j;
            while (i < j && array[i] <= array[loc]) i++;
            UtilArray.swap(array, loc, i);
            loc = i;
        }
        return loc;
    }

    @Test
    public void testSort2(){
        int[] array = {1, 2, 3, 4, 2, 3, 5};
        sort(array, 0, array.length - 1);
        UtilArray.display(array);
    }
}
