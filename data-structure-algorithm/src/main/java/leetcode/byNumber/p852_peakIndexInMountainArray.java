package leetcode.byNumber;

import org.junit.Test;

public class p852_peakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {

        int l = 0;
        int r = arr.length - 1;
        int mid=0 ;
        while (l <= r) {
            mid = l + ((r - l + 1) >> 1);
            if (mid - 1 >= 0 && arr[mid - 1] < arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (arr[mid - 1] < arr[mid]) {
            return mid;
        }
        return mid - 1;
    }

    @Test
    public void test() {
        System.out.println(peakIndexInMountainArray(new int[]{3, 4, 5, 1}));
        System.out.println(peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(peakIndexInMountainArray(new int[]{0, 2,1, 0}));
        System.out.println(peakIndexInMountainArray(new int[]{0, 1,2,1, 0}));
        System.out.println(peakIndexInMountainArray(new int[]{0, 1,2,3,1, 0}));
    }
}
