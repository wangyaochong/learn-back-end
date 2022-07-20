package basic.对象大小;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.util.ArrayList;
import java.util.List;

public class TestObjectSize {
    public static void main(String[] args) {
        List<Long> id = new ArrayList<>();
        for (long i = 0; i < 10000000; i++) {
            id.add(i);
        }
        System.out.println(id.size());
        System.setProperty("java.vm.name", "Java HotSpot(TM) ");
        long intNumber = ObjectSizeCalculator.getObjectSize(1);
        System.out.println(intNumber);
        long longNumber = ObjectSizeCalculator.getObjectSize(1L);
        System.out.println(longNumber);
        long longList = ObjectSizeCalculator.getObjectSize(id);
        System.out.println(longList);
        int i = 295380640 / 1024 / 1024;
        System.out.println("size MB=" + i);
    }
}
