package leetcode.byNumber;

import org.junit.Test;

public class p55_JumpGame {
    public boolean canJump(int[] nums) {
        int maxLoc = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i == maxLoc && nums[i] == 0) {//如果当前位置等于最大距离，并且当前不能往前跳
                return false;
            }
            maxLoc = maxLoc > i + nums[i] ? maxLoc : i + nums[i];
        }
        return true;
    }


    public boolean canJump2(int[] nums) {
        int maxLoc = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxLoc) {//如果当前位置比最大可到位置还远，则返回false
                return false;
            }
            maxLoc = maxLoc > i + nums[i] ? maxLoc : i + nums[i];
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(canJump(new int[]{3, 2, 1, 1, 4}));
    }
}
