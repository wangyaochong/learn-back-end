package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;

public class p321_CreateMaximumNumber_超时了 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] max = new int[k];
        int[] ints = new int[k];
        getResult(nums1, 0, nums2, 0, 0, ints, max);
        return max;
    }

    public void getResult(int[] nums1, int num1Loc, int[] nums2, int num2Loc, int curLoc, int[] tmpResult, int[] max) {

        if (curLoc == tmpResult.length) {
            if (aLeb(max, tmpResult, curLoc)) {
                System.arraycopy(tmpResult, 0, max, 0, tmpResult.length);
            }
            return;
        }
        for (int i = num1Loc; i < nums1.length; i++) {
            tmpResult[curLoc] = nums1[i];
            getResult(nums1, i + 1, nums2, num2Loc, curLoc + 1, tmpResult, max);//选择第一个
        }
        for (int j = num2Loc; j < nums2.length; j++) {
            tmpResult[curLoc] = nums2[j];
            getResult(nums1, num1Loc, nums2, j + 1, curLoc + 1, tmpResult, max);//选择第二个
        }
    }

    public boolean aLeb(int[] a, int[] b, int len) {
        int i = 0;
        while (i < len) {
            if (a[i] < b[i]) {
                return true;
            } else if (a[i] == b[i]) {
                i++;
            } else {
                return false;
            }
        }
        return true;
    }


    @Test
    public void testStringBuilderCmp() {
//        System.out.println(Arrays.toString(maxNumber(new int[]{2, 8, 0, 4, 5, 1, 4, 8, 9, 9, 0, 8, 2, 9}, new int[]{5, 9, 6, 6, 4, 1, 0, 7}, 22)));
        System.out.println(Arrays.toString(maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5)));
    }
}


