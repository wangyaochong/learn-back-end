package 经典算法分类.排序;

import org.junit.Test;
import util.UtilArray;


public class E_MergeSort_Easy_Understand {


    //先实现一个归并方法
    public int[] merge(int[] a, int[] b) {
        int aLoc = 0;
        int bLoc = 0;
        int resultLoc = 0;
        int[] result = new int[a.length + b.length];
        while (aLoc < a.length || bLoc < b.length) {
            if (bLoc == b.length || aLoc < a.length && a[aLoc] < b[bLoc]) {
                result[resultLoc] = a[aLoc];
                aLoc++;
            } else {
                result[resultLoc] = b[bLoc];
                bLoc++;
            }
            resultLoc++;
        }
        return result;
    }

    @Test
    public void testMerge() {
        UtilArray.display(merge(new int[]{1, 3, 5}, new int[]{2, 4, 65}));
        int[] merge = merge(new int[]{1, 2, 5, 3, 6, 2, 11, -1});
        UtilArray.display(merge);
    }


    public int[] merge(int[] array) {
        //如果只剩下一个数字了，就可以直接返回了
        if (array.length == 1) {
            return array;
        }
        int[] frontPart = new int[array.length / 2];
        int[] endPart = new int[array.length - array.length / 2];
        //将数据分成两部分，这个地方这样拆是为了便于理解，可以优化成使用一个数组
        for (int i = 0; i < array.length; i++) {
            if (i < array.length / 2) {
                frontPart[i] = array[i];
            } else {
                endPart[i - array.length / 2] = array[i];
            }
        }

        frontPart = merge(frontPart);
        endPart = merge(endPart);
        return merge(frontPart, endPart);
    }

}
