package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            return Collections.singletonList(String.valueOf(nums[0]));
        }
        StringBuilder one = new StringBuilder();
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (end + 1 == nums[i]) {
                end = nums[i];
                continue;
            } else {
                if (start != end) {
                    one.append(start).append("->").append(end);
                    result.add(one.toString());
                    one = new StringBuilder();
                } else {
                    result.add(String.valueOf(start));
                }
                start = nums[i];
                end = nums[i];
            }
        }
        if (start != end) {
            one.append(start).append("->").append(end);
            result.add(one.toString());
        } else {
            result.add(String.valueOf(start));
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
    }
}
