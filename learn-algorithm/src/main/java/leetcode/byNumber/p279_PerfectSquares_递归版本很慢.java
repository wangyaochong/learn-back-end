package leetcode.byNumber;

import org.junit.Test;

public class p279_PerfectSquares_递归版本很慢 {

    public int numSquares(int n) {
        getResult(n, 0);
        return minCount;
    }

    int minCount = Integer.MAX_VALUE;

    public void getResult(int n, int curCount) {
        if (n == 0) {
            if (minCount > curCount) {
                minCount = curCount;
            }
            return;
        }
        if (n < 0) {
            return;
        }
        double sqrt = Math.sqrt(n);
        int sq = (int) sqrt;
        for (int i = sq; i >= 1; i--) {
            getResult(n - i * i, curCount + 1);
        }
    }

    @Test
    public void test() {
        int i = numSquares(12);
        System.out.println(i);
    }
}
