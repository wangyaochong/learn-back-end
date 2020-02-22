package leetcode.byNumber;

import org.junit.Test;

public class p43_MultiplyStrings_多看 {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];
        int num1Len = num1.length();
        int num2Len = num2.length();
        int c1;
        for (int i = num1Len - 1; i >= 0; i--) {
            c1 = (num1.charAt(i) - '0');
            for (int j = num2Len - 1; j >= 0; j--) {
                int one = c1 * (num2.charAt(j) - '0') + result[i + j + 1];
                result[i + j + 1] = one % 10;
                result[i + j] += one / 10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < result.length && result[i] == 0) {
            i++;
        }
        for (; i < result.length; i++) {
            stringBuilder.append(result[i]);
        }
        if (stringBuilder.toString().length() == 0) {
            return "0";
        }
        return stringBuilder.toString();
    }


    @Test
    public void test() {
        String multiply = multiply("555", "555");
    }
}
