package leetcode.byNumber;

import org.junit.Test;

public class p6_ZigZagConversion_better {
    @Test
    public void test() {
        System.out.println(convert("LEETCODEISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] stringBuilder = new StringBuilder[numRows];
        for (int i = 0; i < stringBuilder.length; i++) {
            stringBuilder[i] = new StringBuilder();
        }
        int row = 0;
        int direction = 1;
        for (int i = 0; i < s.length(); i++) {
            stringBuilder[row].append(s.charAt(i));
            if (row == 0) {
                direction = 1;
            } else if (row == numRows - 1) {
                direction = -1;
            }
            row += direction;

        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder builder : stringBuilder) {
            result.append(builder);
        }
        return result.toString();
    }
}
