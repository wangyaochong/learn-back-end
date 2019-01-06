package leetcode.byNumber;

public class p201_BitwiseANDofNumbersRange_很好 {

    /**
     * 算法思路：
     * 奇数和偶数最后一位与操作会是0
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }
        int moveFactor = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }
}
