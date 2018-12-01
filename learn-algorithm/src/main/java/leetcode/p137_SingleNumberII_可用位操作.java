package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class p137_SingleNumberII_可用位操作 {
    public int singleNumber(int[] nums) {
        long sumDistinct = Arrays.stream(nums).boxed().distinct().mapToLong(e -> e).sum();
        long sumSimple = Arrays.stream(nums).mapToLong(e -> e).sum();
        return (int) ((3 * sumDistinct - sumSimple) / 2);
    }

    @Test
    public void test() {
        System.out.println(singleNumber(new int[]{2, 2, 3, 2}));
    }
}
