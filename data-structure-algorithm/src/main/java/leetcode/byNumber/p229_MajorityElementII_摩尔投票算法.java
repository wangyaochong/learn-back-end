package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p229_MajorityElementII_摩尔投票算法 {

    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        int count1 = 0, num1 = nums[0], count2 = 0, num2 = nums[0];
        for (int num : nums) {
            if (num1 == num) {
                count1++;
                continue;
            }
            if (num2 == num) {
                count2++;
                continue;
            }
            if (count1 == 0) {
                num1 = num;
                count1++;
                continue;
            }
            if (count2 == 0) {
                num2 = num;
                count2++;
                continue;
            }

            count1--;
            count2--;
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == num1) {
                count1++;
            } else if (num == num2) {
                count2++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3) {
            result.add(num1);
        }
        if (count2 > nums.length / 3) {
            result.add(num2);
        }
        return result;
    }


    @Test
    public void test() {
        System.out.println(majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));
    }
}
