package leetcode.byNumber;

import org.junit.Test;

public class p441_ArrangingCoins {

    public int arrangeCoins(int n) {
        return (int) (-1 + Math.pow(1 + (long) n << 3, 0.5)) >> 1;
    }

    @Test
    public void test() {
        System.out.println(arrangeCoins(10));
    }
}
