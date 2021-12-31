import org.junit.Test;

public class 连续字数组的最大值 {

    @Test
    public void test() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};//最大值为6，连续子数组=[4,-1,2,1]
//        int[] dp = new int[ints.length];
//        dp[0] = ints[0];
//        for (int i = 1; i < dp.length; i++) {
//            if (ints[i] >= 0) {
//                dp[i] = dp[i - 1] + ints[i];
//            } else {
//                dp[i] = Math.max(dp[i - 1], ints[i]);
//            }
//        }
//        System.out.println(dp[ints.length - 1]);


        int max = nums[0];
        int tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tmp = Math.max(tmp + nums[i], nums[i]);
            max = Math.max(tmp, max);
        }
        System.out.println(max);
    }
}
