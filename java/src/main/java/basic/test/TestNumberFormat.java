package basic.test;

import org.junit.Test;

import java.text.NumberFormat;

public class TestNumberFormat {
    @Test
    public void test() {
        NumberFormat instance = NumberFormat.getInstance();
        instance.setMinimumIntegerDigits(5);
        instance.setMinimumFractionDigits(5);
        instance.setGroupingUsed(false);
        System.out.println(instance.format(1.11));
        System.out.println(String.format("%015d", 1));

    }

    @Test
    public void test2() {
        NumberFormat instance = NumberFormat.getInstance();
        instance.setMinimumFractionDigits(2);
        instance.setGroupingUsed(false);
        System.out.println(instance.format(12.11));
        System.out.println(instance.format(12.1));
        System.out.println(instance.format(12));

    }
}
