package multiThread.三个线程顺序执行.一次性.lockConditionWithoutIndex;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionMain2 {
    public static void main(String[] args) {


        ReentrantLock lock1 = new ReentrantLock(true);
        Condition condition1 = lock1.newCondition();
        ReentrantLock lock2 = new ReentrantLock(true);
        Condition condition2 = lock2.newCondition();
        ReentrantLock lock3 = new ReentrantLock(true);
        Condition condition3 = lock3.newCondition();
        LockConditionTask2 t1 = new LockConditionTask2("t1", lock1, null, lock2, condition2);
        LockConditionTask2 t2 = new LockConditionTask2("t2", lock2, condition2, lock3, condition3);
        LockConditionTask2 t3 = new LockConditionTask2("t3", lock3, condition3, lock1, null);
        t1.start();
        t2.start();
        t3.start();

    }
}
