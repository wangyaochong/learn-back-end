package multiThread.三个线程顺序执行.持续性_比如交替打印1到100.lockCondition;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class LockConditionTask3 extends Thread {
    private final String name;
    private final Lock lock;
    private final Condition condition;

    private final Lock otherLock;
    private final Condition otherCondition;

    private final AtomicInteger count;
    private static final AtomicBoolean isFirst = new AtomicBoolean(true);

    public LockConditionTask3(String name, Lock lock, Condition condition, Lock otherLock, Condition otherCondition, AtomicInteger count) {
        this.name = name;
        this.lock = lock;
        this.condition = condition;
        this.otherCondition = otherCondition;
        this.otherLock = otherLock;
        this.count = count;
    }

    @Override public void run() {
        while (count.get() < 100) {
            lock.lock();
            try {
                if (condition != null) {
                    boolean b = isFirst.compareAndSet(true, false);//并发只有一次会成功，唯一成功的这一次不需要await，其他的都需要await
                    if (!b) {
                        condition.await();
                    }
                }
                if (count.get() >= 100) {
                    otherLock.lock();
                    if (otherCondition != null) {
                        otherCondition.signalAll();
                    }
                    otherLock.unlock();
                    break;
                }
                count.incrementAndGet();
                System.out.println("finish run " + this.name + " " + count.get());
                otherLock.lock();
                if (otherCondition != null) {
                    otherCondition.signalAll();
                }
                otherLock.unlock();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.unlock();
        }
    }
}
