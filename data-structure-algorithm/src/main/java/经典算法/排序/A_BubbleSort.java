package 经典算法.排序;

import org.junit.Test;
import util.UtilArray;

/**
* @author wangyaochong
* @date 2021/6/2
*/

public class A_BubbleSort {

    @Test
    public void test() {
        int[] array = {1, 2, 3, 4, 2, 3, 5};
        sort(array);
        UtilArray.display(array);
    }

    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    UtilArray.swap(array, j - 1, j);
                }
            }
        }
    }


    @Test
    public void test2(){
        int[] arr=new int[]{1,3,4,5,2,9,0};
        for(int i=0;i<arr.length;i++){
            for(int j=0;j+1<arr.length-i;j++){
                if(arr[j]>arr[j+1]){
                    UtilArray.swap(arr,j,j+1);
                }
            }
        }
        UtilArray.display(arr);

    }
}
