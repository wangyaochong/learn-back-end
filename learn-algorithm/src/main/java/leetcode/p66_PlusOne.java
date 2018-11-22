package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class p66_PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 0, tmp;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                tmp = digits[i] + 1 + carry;
            } else {
                tmp = digits[i] + carry;
            }
            digits[i] = tmp % 10;
            carry = tmp / 10;
        }
        if (carry != 0) {
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            for (int i = 1; i < result.length; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        }
        return digits;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
    }
}
