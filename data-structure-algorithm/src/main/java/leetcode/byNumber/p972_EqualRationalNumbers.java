package leetcode.byNumber;

import org.junit.Test;

public class p972_EqualRationalNumbers {
    public boolean isRationalEqual(String S, String T) {
        String substringS, substringT;
        StringBuilder s = new StringBuilder(), t = new StringBuilder();
        int sIndex = S.indexOf('('), tIndex = T.indexOf('(');
        if (sIndex != -1) {
            s.append(S, 0, sIndex);
            substringS = S.substring(sIndex + 1, S.length() - 1);
            while (s.length() < 50) s.append(substringS);
        } else s.append(S);
        if (tIndex != -1) {
            t.append(T, 0, tIndex);
            substringT = T.substring(tIndex + 1, T.length() - 1);
            while (t.length() < 50) t.append(substringT);
        } else t.append(T);
        return Double.parseDouble(s.toString()) == Double.parseDouble(t.toString());
    }

    @Test
    public void testResult() {
//        System.out.println(isRationalEqual("0.16(6)", "0.1(66)"));
//        System.out.println(isRationalEqual("0.(9)", "1."));
        System.out.println(isRationalEqual("0.(52)", "0.5(25)"));
    }

    @Test
    public void test() {
        System.out.println("12(12)".replaceAll("\\(\\d*\\)", ""));
    }

    @Test
    public void testParse() {
        double v = Double.parseDouble("1.1111111111111111111111111111111111111111111111111111111111111111111");
        double v2 = Double.parseDouble("0.9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
        System.out.println(v);
        System.out.println(v2 == 1.0);
    }


    public String revert(String s) {
        if (s.length() == 0) {
            return s;
        }
        return s.charAt(s.length() - 1) + revert(s.substring(0, s.length() - 1));
    }

    @Test
    public void testRevert() {
        System.out.println(revert("123"));
    }
}
