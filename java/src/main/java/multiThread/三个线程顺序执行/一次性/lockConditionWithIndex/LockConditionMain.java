package multiThread.三个线程顺序执行.一次性.lockConditionWithIndex;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionMain {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        AtomicInteger currentIndex = new AtomicInteger();
        LockConditionTask t1 = new LockConditionTask("t1", lock, condition, 0, currentIndex);
        LockConditionTask t2 = new LockConditionTask("t2", lock, condition, 1, currentIndex);
        LockConditionTask t3 = new LockConditionTask("t3", lock, condition, 2, currentIndex);
        t1.start();
        t2.start();
        t3.start();
    }
}
