package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;

public class p179_LargestNumber {

    public String largestNumber(int[] nums) {
        String reduce = Arrays.stream(nums).mapToObj(String::valueOf).sorted((a, b) -> (b + a).compareTo(a + b)).reduce("", String::concat);
        int i = 0;
        while (i < reduce.length() - 1 && reduce.charAt(i) == '0') i++;
        return reduce.substring(i);
    }

    @Test
    public void test() {
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(largestNumber(new int[]{33, 34, 30, 3}));
        System.out.println(largestNumber(new int[]{30, 3}));
        System.out.println(largestNumber(new int[]{3, 30}));
        System.out.println(largestNumber(new int[]{1, 1, 1}));
        System.out.println(largestNumber(new int[]{0, 0, 0}));
    }
}
