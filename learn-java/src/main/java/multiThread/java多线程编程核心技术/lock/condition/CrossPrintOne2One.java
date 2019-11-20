package multiThread.java多线程编程核心技术.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CrossPrintOne2One {

    static class BooleanObject {
        boolean flag;
    }

    public static void main(String[] args) {
        BooleanObject booleanObject = new BooleanObject();
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    if (booleanObject.flag) {
                        System.out.println("A");
                        booleanObject.flag = false;
                        condition.signal();
                    } else {
                        condition.await();
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                } finally {
                    lock.unlock();
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    if (!booleanObject.flag) {
                        System.out.println("B");
                        booleanObject.flag = true;
                        condition.signal();
                    } else {
                        condition.await();
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}
