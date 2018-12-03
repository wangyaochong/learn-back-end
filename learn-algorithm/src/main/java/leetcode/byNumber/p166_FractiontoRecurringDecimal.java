package leetcode.byNumber;

import org.junit.Test;

public class p166_FractiontoRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        int curLend = 1;
        if (numerator < denominator) {
            curLend *= 10;
        }
        int mod = numerator % denominator;
        while (mod != 0) {

        }
        return null;
    }

    @Test
    public void test() {

    }


}
