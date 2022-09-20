package multiThread.三个线程顺序执行.持续性_比如交替打印1到100.lockCondition;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionMain3 {
    public static void main(String[] args) {


        ReentrantLock lock1 = new ReentrantLock(true);
        Condition condition1 = lock1.newCondition();
        ReentrantLock lock2 = new ReentrantLock(true);
        Condition condition2 = lock2.newCondition();
        ReentrantLock lock3 = new ReentrantLock(true);
        Condition condition3 = lock3.newCondition();
        AtomicInteger count = new AtomicInteger();
        LockConditionTask3 t1 = new LockConditionTask3("t1", lock1, condition1, lock2, condition2, count);
        LockConditionTask3 t2 = new LockConditionTask3("t2", lock2, condition2, lock3, condition3, count);
        LockConditionTask3 t3 = new LockConditionTask3("t3", lock3, condition3, lock1, condition1, count);
        t1.start();
        t2.start();
        t3.start();

    }
}
