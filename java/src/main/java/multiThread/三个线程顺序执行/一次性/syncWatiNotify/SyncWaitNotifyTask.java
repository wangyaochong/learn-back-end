package multiThread.三个线程顺序执行.一次性.syncWatiNotify;

import java.util.concurrent.atomic.AtomicInteger;

public class SyncWaitNotifyTask extends Thread {
    private final String name;
    private final int index;
    private final AtomicInteger currentIndex;

    public SyncWaitNotifyTask(String name, int index, AtomicInteger currentIndex) {
        this.name = name;
        this.index = index;
        this.currentIndex = currentIndex;
    }

    @Override public void run() {
        synchronized (currentIndex) {
            while (index != currentIndex.get()) {
                // do nothing
                try {
                    System.out.println("wait " + this.name);
                    currentIndex.wait();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("start run " + this.name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("finish run " + this.name);
            currentIndex.incrementAndGet();
            currentIndex.notifyAll();
        }
    }
}
