package multiThread.三个线程顺序执行.一次性.syncWatiNotify;

import java.util.concurrent.atomic.AtomicInteger;

public class SyncWaitNotifyMain {
    public static void main(String[] args) {
        AtomicInteger currentIndex = new AtomicInteger();
        SyncWaitNotifyTask t1 = new SyncWaitNotifyTask("t1", 0, currentIndex);
        SyncWaitNotifyTask t2 = new SyncWaitNotifyTask("t2", 1, currentIndex);
        SyncWaitNotifyTask t3 = new SyncWaitNotifyTask("t3", 2, currentIndex);
        t1.start();
        t2.start();
        t3.start();
    }
}
