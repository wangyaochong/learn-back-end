package leetcode.byNumber;

public class p171_ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int sum = 0;
        int carry = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            sum += (s.charAt(i) - 'A' + 1) * carry;
            carry *= 26;
        }
        return sum;
    }
}
