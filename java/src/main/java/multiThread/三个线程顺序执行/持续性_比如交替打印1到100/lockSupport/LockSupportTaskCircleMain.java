package multiThread.三个线程顺序执行.持续性_比如交替打印1到100.lockSupport;

import java.util.concurrent.atomic.AtomicInteger;

public class LockSupportTaskCircleMain {
    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger();
        LockSupportTaskCircle t3 = new LockSupportTaskCircle("t3", null, count);
        LockSupportTaskCircle t2 = new LockSupportTaskCircle("t2", t3, count);
        LockSupportTaskCircle t1 = new LockSupportTaskCircle("t1", t2, count);
        t3.setNext(t1);
        t1.start();
        t2.start();
        t3.start();
    }
}
