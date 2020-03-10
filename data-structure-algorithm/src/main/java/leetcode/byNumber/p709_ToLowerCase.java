package leetcode.byNumber;

import org.junit.Test;

public class p709_ToLowerCase {

    public String toLowerCase(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) <= 90 && str.charAt(i) >= 65) {
                stringBuilder.append((char) (str.charAt(i) + 32));
            } else {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public String toLowerCase2(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= 90 && str.charAt(i) >= 65) {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return new String(chars);
    }

    @Test
    public void test() {
        System.out.println('A' - 'a');
        System.out.println((int) 'A');
        System.out.println((int) 'Z');
        System.out.println((int) 'a');
    }

    @Test
    public void testToLowerCase() {
        System.out.println(toLowerCase("AbcDEF"));
        System.out.println(toLowerCase2("AbcDEF"));
    }
}
