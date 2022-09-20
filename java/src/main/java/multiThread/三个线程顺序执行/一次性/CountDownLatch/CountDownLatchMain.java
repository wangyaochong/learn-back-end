package multiThread.三个线程顺序执行.一次性.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchMain {
    public static void main(String[] args) {
        CountDownLatch t2Start = new CountDownLatch(1);
        CountDownLatch t3Start = new CountDownLatch(1);
        CountDownLatchTask t1 = new CountDownLatchTask("t1", null, t2Start);
        CountDownLatchTask t2 = new CountDownLatchTask("t2", t2Start, t3Start);
        CountDownLatchTask t3 = new CountDownLatchTask("t3", t3Start, null);
        t1.start();
        t2.start();
        t3.start();
    }
}
