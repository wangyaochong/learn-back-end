package multiThread.java多线程编程核心技术.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CirclePrint {
    int flag = 0;

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition0 = lock.newCondition();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        CirclePrint circlePrint = new CirclePrint();
        new Thread(() -> {
            while (true) {

                lock.lock();
                if (circlePrint.flag == 0) {
                    System.out.println(circlePrint.flag);
                    circlePrint.flag = (circlePrint.flag + 1) % 3;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    condition1.signal();
                } else {
                    try {
                        condition0.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            while (true) {

                lock.lock();
                if (circlePrint.flag == 1) {
                    System.out.println(circlePrint.flag);
                    circlePrint.flag = (circlePrint.flag + 1) % 3;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    condition2.signal();
                } else {
                    try {
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.unlock();
            }
        }).start();


        new Thread(() -> {
            while (true) {

                lock.lock();
                if (circlePrint.flag == 2) {
                    System.out.println(circlePrint.flag);
                    circlePrint.flag = (circlePrint.flag + 1) % 3;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    condition0.signal();
                } else {
                    try {
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.unlock();
            }
        }).start();
    }
}
