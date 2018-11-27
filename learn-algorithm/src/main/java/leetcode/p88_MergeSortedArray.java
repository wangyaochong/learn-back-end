package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class p88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Loc = nums1.length - 1;
        m--;
        n--;
        while (nums1Loc >= 0) {
            if (n < 0 || m >= 0 && nums1[m] > nums2[n]) {
                nums1[nums1Loc] = nums1[m];
                m--;
            } else {
                nums1[nums1Loc] = nums2[n];
                n--;
            }
            nums1Loc--;
        }
    }

    @Test
    public void test() {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));

    }
}
