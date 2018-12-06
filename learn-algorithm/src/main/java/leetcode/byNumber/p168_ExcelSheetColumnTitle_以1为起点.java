package leetcode.byNumber;

import org.junit.Test;

public class p168_ExcelSheetColumnTitle_以1为起点 {


    public Long fromAbcToTen(String abc) {
        Long sum = 0L;
        int carry = 1;
        for (int i = abc.length() - 1; i >= 0; i--) {
            sum += (abc.charAt(i) - 'A' + 1) * carry;
            carry *= 26;
        }
        return sum;
    }

    @Test
    public void testFromAbc() {
        System.out.println(fromAbcToTen("ZY"));
    }

    public String answer(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n--;
            result.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }
        return result.toString();
    }

    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        int start = n;
        while (start > 0) {
            result.append((char) ((start - 1) % 26 + 'A'));
            start = (start - 1) / 26;
        }
        return result.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(convertToTitle(52));
    }
}
