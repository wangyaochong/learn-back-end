package leetcode.byNumber;

public class p343_IntegerBreak_数学题 {
    public int integerBreak(int n) {
        if (n == 2 || n == 3)
            return n - 1;
        int res = 1;
        while (n > 4) {
            n = n - 3;
            res = res * 3;
        }
        return n * res;
    }
}
