package leetcode.byNumber;

public class p326_PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (n % 3 == 0) {
            return isPowerOfThree(n / 3);
        }
        return false;
    }
}
