package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;

public class p321_CreateMaximumNumber_提前算好数量_快一些_还是超时 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] max = new int[k];
        for (int i = 0; i <= k; i++) {
            if (nums1.length >= i && nums2.length >= k - i) {
                int[] n1Max = maxCombine(nums1, i);
                int[] n2Max = maxCombine(nums2, k - i);
                int[] merge = merge(n1Max, n2Max);
                if (isBigger(merge, max, 0, 0)) {
                    System.arraycopy(merge, 0, max, 0, max.length);
                }
            }
        }
        return max;
    }

    public int[] merge(int[] a, int[] b) {
        int aLoc = 0;
        int bLoc = 0;
        int[] result = new int[a.length + b.length];
        int rLoc = 0;
        while (aLoc < a.length || bLoc < b.length) {
            if (bLoc == b.length || aLoc < a.length && isBigger(a, b, aLoc, bLoc)) {
                result[rLoc] = a[aLoc];
                aLoc++;
            } else {
                result[rLoc] = b[bLoc];
                bLoc++;
            }
            rLoc++;
        }
        return result;
    }

    public boolean isBigger(int[] a, int[] b, int aStart, int bStart) {
        while (aStart < a.length && bStart < b.length) {
            if (a[aStart] > b[bStart]) {
                return true;
            } else if (a[aStart] < b[bStart]) {
                return false;
            }
            aStart++;
            bStart++;
        }
        return a.length != aStart;//当这个先消耗掉
    }

    public int[] maxCombine(final int[] candidate, int k) {
        int[] result = new int[k];
        getResult(candidate, new int[k], result, 0, 0);
        return result;
    }

    public void getResult(final int[] candidate, int[] tmpResult, int[] result, int lastLoc, int curLoc) {
        if (curLoc == tmpResult.length) {
            if (isBigger(tmpResult, result, 0, 0)) {
                System.arraycopy(tmpResult, 0, result, 0, tmpResult.length);
            }
            return;
        }

        for (int i = 0; i < curLoc; i++) {
            if (tmpResult[i] < result[i]) {
                return;
            }
        }

        for (int i = lastLoc; i < candidate.length && candidate.length - i >= tmpResult.length - curLoc; i++) {
            tmpResult[curLoc] = candidate[i];
            getResult(candidate, tmpResult, result, i + 1, curLoc + 1);
        }
    }


    @Test
    public void testStringBuilderCmp() {
//        System.out.println(Arrays.toString(maxNumber(new int[]{2, 8, 0, 4, 5, 1, 4, 8, 9, 9, 0, 8, 2, 9}, new int[]{5, 9, 6, 6, 4, 1, 0, 7}, 22)));
//        System.out.println(Arrays.toString(maxNumber(new int[]{4, 1, 2, 5, 8, 5, 7, 3, 7, 3, 0, 5, 8, 9, 5, 7, 3, 3, 4, 4, 0}, new int[]{7, 8, 4, 8, 9, 5, 0, 4, 0, 8, 2}, 32)));
        int[] nums1 = {8, 0, 4, 4, 1, 7, 3, 6, 5, 9, 3, 6, 6, 0, 2, 5, 1, 7, 7, 7, 8, 7, 1, 4, 4, 5, 4, 8, 7, 6, 2, 2, 9, 4, 7, 5, 6, 2, 2, 8, 4, 6, 0, 4, 7, 8, 9, 1, 7, 0};
        int[] nums2 = {6, 9, 8, 1, 1, 5, 7, 3, 1, 3, 3, 4, 9, 2, 8, 0, 6, 9, 3, 3, 7, 8, 3, 4, 2, 4, 7, 4, 5, 7, 7, 2, 5, 6, 3, 6, 7, 0, 3, 5, 3, 2, 8, 1, 6, 6, 1, 0, 8, 4};
        System.out.println(nums1.length);
        System.out.println(nums2.length);
        System.out.println(Arrays.toString(maxNumber(nums1, nums2, 50)));
    }

    @Test
    public void testMaxCombine() {
        System.out.println(Arrays.toString(maxCombine(new int[]{9, 1, 2, 5, 8, 3}, 4)));
    }

    @Test
    public void testMerge() {
//        System.out.println(Arrays.toString(merge(new int[]{9, 3, 1}, new int[]{10, 7, 2})));
        int[] ints = {6, 3, 9, 0, 5, 6};
        int[] ints1 = {2, 2, 5, 2, 1, 4, 4, 5, 7, 8, 9, 3, 1, 6, 9, 7, 0};
        System.out.println(ints.length);
        System.out.println(ints1.length);
        System.out.println(Arrays.toString(merge(ints, ints1)));
    }
}


