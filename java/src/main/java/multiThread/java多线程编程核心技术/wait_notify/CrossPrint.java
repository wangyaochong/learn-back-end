package multiThread.java多线程编程核心技术.wait_notify;

public class CrossPrint {//同过一个锁来实现线程的交替打印，其实就是生产者消费者

    static class BooleanObject {
        boolean flag;
    }

    public static void main(String[] args) {
        Object lock = new Object();
        BooleanObject booleanObject = new BooleanObject();
        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (booleanObject.flag) {
                        System.out.println("A");
                        booleanObject.flag = false;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (!booleanObject.flag) {
                        System.out.println("B");
                        booleanObject.flag = true;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}
