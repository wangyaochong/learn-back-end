package multiThread.三个线程顺序执行.一次性.lockConditionWithIndex;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class LockConditionTask extends Thread {
    private final Lock lock;
    private final Condition condition;
    private final AtomicInteger currentIndex;
    private final int index;
    private String name;

    public LockConditionTask(String name, Lock lock, Condition condition, int index, AtomicInteger currentIndex) {
        this.name = name;
        this.lock = lock;
        this.condition = condition;
        this.index = index;
        this.currentIndex = currentIndex;
    }

    @Override
    public void run() {
        lock.lock();
        while (this.index != currentIndex.get()) {
            try {
                condition.await();
            } catch (InterruptedException e) {
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
        condition.signalAll();
        lock.unlock();
    }
}
