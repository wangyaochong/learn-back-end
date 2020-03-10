package leetcode.byNumber;

import org.junit.Test;

public class p67_AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0, tmp;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                tmp = b.charAt(j) - '0' + carry;
            } else if (j < 0) {
                tmp = a.charAt(i) - '0' + carry;
            } else {
                tmp = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            }
            stringBuilder.append(tmp % 2);
            carry = tmp / 2;
            i--;
            j--;
        }
        if (carry != 0) {
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(addBinary("1010", "1011"));
    }
}
