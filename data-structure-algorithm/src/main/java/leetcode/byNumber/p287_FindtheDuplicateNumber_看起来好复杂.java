package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;

public class p287_FindtheDuplicateNumber_看起来好复杂 {
    public int findDuplicate(int[] nums) {
        int[] loc = new int[nums.length + 1];//记录每个数字的下标
        Arrays.fill(loc, Integer.MIN_VALUE);
        for (int i = 0; i < nums.length; i++) {
            if (loc[nums[i]] == Integer.MIN_VALUE) {
                loc[nums[i]] = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) {
                continue;
            } else {
                if (nums[i] != nums[nums[i] - 1]) {//如果说原有位置不等于nums[i]，调换
                    if (loc[i + 1] == Integer.MIN_VALUE) {//说明没有i+1这个数字
                        continue;
                    }
                    if (nums[loc[i + 1]] == nums[i]) {
                        return nums[i];
                    }
                    int tmpLoc = loc[i + 1];
                    int tmp = loc[nums[i]];
                    loc[nums[i]] = loc[nums[loc[i + 1]]];
                    loc[nums[loc[i + 1]]] = tmp;

                    tmp = nums[tmpLoc];
                    nums[tmpLoc] = nums[i];
                    nums[i] = tmp;

                } else {//如果说原有位置等于nums[i]，则说明这个是重复数字
                    return nums[i];
                }
            }
        }
        return 0;
    }

    @Test
    public void test() {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicate(new int[]{3, 2, 2, 2, 4}));
    }
}


