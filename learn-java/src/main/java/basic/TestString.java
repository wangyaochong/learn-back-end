package basic;

import org.junit.Test;

public class TestString {

    @Test
    public void testContains() {
        System.out.println("abcdefg".contains("cde"));
    }

    @Test
    public void test() {
        String a = "a";
        String b = "b";
        String ab = "ab";
        String ab2 = "a" + "b";
        String ab3 = new String(ab);
        System.out.println(ab == ab2);//java有字符串常量
        System.out.println(ab == ab3);//java有字符串常量
        Integer i1 = 1;
        Integer i2 = 1;
        System.out.println(i1 == i2);//java也有数字常量
    }
}
