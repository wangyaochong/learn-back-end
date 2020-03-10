package leetcode.byNumber;

import org.junit.Test;

public class p6_ZigZagConversion {
    @Test
    public void test() {
        System.out.println(convert("AB", 1));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] stringBuilder = new StringBuilder[numRows];
        for (int i = 0; i < stringBuilder.length; i++) {
            stringBuilder[i] = new StringBuilder();
        }

        int xLoc = 0;
        int yLoc = 0;
        int directX = 1;
        int directY = 0;
        for (int i = 0; i < s.length(); i++) {
            stringBuilder[xLoc].append(s.charAt(i));
            if (xLoc + directX >= stringBuilder.length) {
                directX = -1;
                directY = 1;
            } else if (xLoc + directX < 0) {
                directX = 1;
                directY = 0;
            }
            xLoc += directX;
            yLoc += directY;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder builder : stringBuilder) {
            result.append(builder);
        }
        return result.toString();
    }
}
