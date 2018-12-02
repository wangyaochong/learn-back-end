package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class p120_Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> integers = triangle.get(i);
            for (int j = 0; j < integers.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + integers.get(j);
            }
        }
        return dp[0];
    }


    @Test
    public void test() {

        List<List<Integer>> tmp = new ArrayList<List<Integer>>() {{
            add(Collections.singletonList(-1));
            add(Arrays.asList(2, 3));
            add(Arrays.asList(1, -1, -3));
//            add(Arrays.asList(4, 1, 8, 3));
        }};
        System.out.println(minimumTotal(tmp));

    }
}
