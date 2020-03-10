package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p228_SummaryRanges_更好 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            return Collections.singletonList(String.valueOf(nums[0]));
        }
        int i = 0;
        while (i < nums.length) {
            int start = nums[i];
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (start == nums[i]) {
                result.add(String.valueOf(nums[i]));
            } else {
                result.add(start + "->" + nums[i]);
            }
            i++;
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7, 8}));
    }
}
