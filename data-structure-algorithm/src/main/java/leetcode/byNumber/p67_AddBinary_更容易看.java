package leetcode.byNumber;

import org.junit.Test;

public class p67_AddBinary_更容易看 {
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int length = Math.max(a.length(), b.length());
        int carry = 0;
        int tmp;
        int loc = 0;
        while (loc < length) {
            int aNum = loc < a.length() ? a.charAt(loc) - '0' : 0;
            int bNum = loc < b.length() ? b.charAt(loc) - '0' : 0;
            tmp = (aNum + bNum + carry) % 2;
            carry = (aNum + bNum + carry) / 2;
            stringBuilder.append(tmp);
            loc++;
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
