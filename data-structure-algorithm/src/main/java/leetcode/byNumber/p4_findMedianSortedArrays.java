package leetcode.byNumber;

import org.junit.Test;

public class p4_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) { // 确保nums1的长度小于nums2的长度
            return findMedianSortedArrays(nums2, nums1);
        }
        int totalLeftCount = (nums1.length + nums2.length + 1) / 2; //这个地方注意这个+1
        int start = 0;
        int end = nums1.length;
        while (start < end) {
            int leftCount = start + (end - start + 1) / 2; //这里的leftCount其实是nums1数组的左边划分的数量
            if (nums1[leftCount - 1] > nums2[totalLeftCount - leftCount]) {
                end = leftCount - 1;
            } else {
                start = leftCount;
            }
        }
        int i = start;
        int j = totalLeftCount - i;
        double left1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int right1 = i == nums1.length ? Integer.MAX_VALUE : nums1[i];
        int left2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int right2 = j == nums2.length ? Integer.MAX_VALUE : nums2[j];
        if ((nums1.length + nums2.length) % 2 == 1) {
            return Math.max(left1, left2);
        } else {
            return (Math.max(left1, left2) + Math.min(right1, right2)) / (double) 2;
        }
    }

    @Test
    public void test() {
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{4, 5, 6};
        int[] arr3 = new int[]{1, 3};
        int[] arr4 = new int[]{2};
        double medianSortedArrays = findMedianSortedArrays(arr2, arr1);
        double medianSortedArrays2 = findMedianSortedArrays(arr3, arr4);
    }
}
