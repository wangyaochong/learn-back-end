package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class p136_SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = (result ^ nums[i]);
        }

        return result;
    }

    public int singleNumber求和法(int[] nums) {

        Set<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int sum = collect.stream().mapToInt(e -> e).sum();
        return 2 * sum - Arrays.stream(nums).sum();
    }

    @Test
    public void test() {
        System.out.println(singleNumber(new int[]{1, 1, 2}));
        System.out.println(singleNumber求和法(new int[]{1, 1, 2}));
    }
}
