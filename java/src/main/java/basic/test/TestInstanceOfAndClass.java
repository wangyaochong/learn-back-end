package basic.test;

import cn.hutool.core.util.ClassUtil;

public class TestInstanceOfAndClass {
    public static void main(String[] args) {
        System.out.println(int.class);
        Object test=1;
        Integer integer=1;
        System.out.println(test.getClass());
        int i=1;
        System.out.println(ClassUtil.getClass(i));
    }
}
