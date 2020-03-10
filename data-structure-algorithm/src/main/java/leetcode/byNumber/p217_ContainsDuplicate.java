package leetcode.byNumber;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class p217_ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
    }
}
