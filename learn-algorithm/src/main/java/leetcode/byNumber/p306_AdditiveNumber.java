package leetcode.byNumber;

import org.junit.Test;

import java.math.BigDecimal;

public class p306_AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        int length = num.length();
        if (length < 3) {
            return false;
        }
        for (int i = 1; i < length / 2 + 1; i++) {
            for (int j = i + 1; length - j >= j - i && length - j >= i; j++) {
                if (num.charAt(0) == '0' && i > 1 || num.charAt(i) == '0' && j > i + 1) {
                    continue;
                }
                if (getResult(new BigDecimal(num.substring(0, i)), new BigDecimal(num.substring(i, j)), num.substring(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean getResult(BigDecimal last2, BigDecimal last1, String left) {
        if (left.length() == 0) {
            return true;
        }
        for (int i = 1; i <= left.length(); i++) {
            if (left.charAt(0) == '0' && i > 1) {
                continue;
            }
            String substring = left.substring(0, i);
            BigDecimal curNumber = new BigDecimal(substring);
            if (curNumber.compareTo(last1.add(last2)) > 0) {
                break;
            }
            if (curNumber.compareTo(last1.add(last2)) == 0) {
                return getResult(last1, curNumber, left.substring(i));
            }
        }
        return false;
    }


    @Test
    public void test() {
        System.out.println(isAdditiveNumber("101"));
        System.out.println(isAdditiveNumber("123"));
        System.out.println(isAdditiveNumber("1023"));
        System.out.println(isAdditiveNumber("112358"));
        System.out.println(isAdditiveNumber("21223"));
        System.out.println(isAdditiveNumber("111"));
        System.out.println(new BigDecimal("04").toString());
        //        System.out.println(getResult(0, 1, "123"));

//        System.out.println("21223".substring(5));
    }
}
