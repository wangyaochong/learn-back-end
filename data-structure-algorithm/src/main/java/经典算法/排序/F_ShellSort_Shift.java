package 经典算法.排序;


import org.junit.Test;

import java.util.Arrays;

/**
 * 插入排序的升级版
 */
public class F_ShellSort_Shift {

    int shellCount = 0;
    int insertCount = 0;

    //先写个插入排序练手
    public int[] insertSort(int data[]) {
        for (int i = 0; i < data.length; i++) {
            int j = i;
            int flag = data[j];
            while (j > 0 && flag < data[j - 1]) {
                data[j] = data[j - 1];
                insertCount++;
                j--;
            }
            data[j] = flag;
        }
        return data;
    }

    /**
     * 按照步长进行分组排序
     */
    public int[] partInsertSort(int[] data, int pos, int step) {
        for (int i = pos; i < data.length; i += step) {
            int j = i;
            int flag = data[j];
            while (j > step && flag < data[j - step]) {
                data[j] = data[j - step];
                shellCount++;
                j -= step;
            }
            data[j] = flag;
        }
        return data;
    }


    public int[] shellSort(int[] data) {
        int step = data.length / 2;
        //虽然这里是四层循环，但是实际上，如果仔细看，可以发现第二个循环和第三个循环可以合并成一个
        //for(int i=0;i<data.length;i++)
        while (step > 0) {
            for (int i = 0; i < step; i++) {
                partInsertSort(data, i, step);
            }
            step /= 2;
        }
        return data;
    }

    @Test
    public void testShellSort() {
        int[] data = {1, 3, 5, 2, 8, 6, 1, 2, 1, 3, 5};
        int[] data2 = {1, 3, 5, 2, 8, 6, 1, 2, 1, 3, 5};
        System.out.println(Arrays.toString(shellSort(data)));
        System.out.println(Arrays.toString(insertSort(data2)));
        //可以看到希尔排序的计算次数更少
        System.out.println(shellCount);
        System.out.println(insertCount);
    }
}
