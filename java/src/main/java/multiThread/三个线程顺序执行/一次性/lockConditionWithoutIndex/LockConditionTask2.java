package multiThread.三个线程顺序执行.一次性.lockConditionWithoutIndex;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class LockConditionTask2 extends Thread {
    private final String name;
    private final Lock lock;
    private final Condition condition;

    private final Lock otherLock;
    private final Condition otherCondition;

    public LockConditionTask2(String name, Lock lock, Condition condition, Lock otherLock, Condition otherCondition) {
        this.name = name;
        this.lock = lock;
        this.condition = condition;
        this.otherCondition = otherCondition;
        this.otherLock = otherLock;
    }

    @Override public void run() {
        lock.lock();
        try {
            if (condition != null) {
                condition.await();
            }
            System.out.println("start run " + this.name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("finish run " + this.name);
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
