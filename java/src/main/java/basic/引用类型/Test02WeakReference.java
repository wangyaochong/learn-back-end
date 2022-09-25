package basic.引用类型;

import java.lang.ref.WeakReference;

public class Test02WeakReference {

    public static void main(String[] args) throws InterruptedException {
        MyClass myClass = new MyClass();
        myClass.count = new Integer(1);
        WeakReference<Integer> weakReference = new WeakReference<>(myClass.count);
        System.out.println(weakReference.get());
        myClass.count = null;
        System.out.println(weakReference.get());
        System.gc();
        Thread.sleep(1000);
        System.out.println(weakReference.get());
    }
}
