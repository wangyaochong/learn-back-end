package basic.java对象头;

import org.openjdk.jol.info.ClassLayout;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author wangyaochong
 * @date 2020/3/26 15:37
 */
public class TestObjectHead {
    int intField;
    boolean booleanField;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        ClassLayout classLayout = ClassLayout.parseInstance(new TestObjectHead());
//        SortedSet<FieldLayout> fields = classLayout.fields();
//        System.out.println(fields);
//        System.out.println(classLayout);
//        System.out.println(classLayout.toPrintable());
        testSynchronized();
    }

    public static void testSynchronized() throws NoSuchFieldException, IllegalAccessException {

        TestObjectHead testObjectHead = new TestObjectHead();
        System.out.println("线程id=" + Thread.currentThread().getId());
        System.out.println("哈希code=" + Integer.toHexString(testObjectHead.hashCode()));
        System.out.println("哈希util, code=" + countHash(testObjectHead));

        System.out.println(ClassLayout.parseInstance(testObjectHead).toPrintable());
        System.out.println("-----------------------加锁--------------------");
        synchronized (testObjectHead) {
            System.out.println(ClassLayout.parseInstance(testObjectHead).toPrintable());
        }
        System.out.println("-----------------------解锁--------------------");
        System.out.println(ClassLayout.parseInstance(testObjectHead).toPrintable());
    }


    public static String countHash(Object object) throws NoSuchFieldException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        long hashCode = 0;
        for (long index = 7 ; index > 0 ; index--) {
            hashCode |= (unsafe.getByte(object, index) & 0xff) << ((index - 1) * 8);
        }
        return Long.toHexString(hashCode);
    }
}
