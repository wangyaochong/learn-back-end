package multiThread.java多线程编程核心技术.wait_notify;

public class ProducerConsumerWithWaitNotify {
    static class ValueObject {
        int value;
    }

    public static void main(String[] args) {
        Object lock = new Object();
        ValueObject valueObject = new ValueObject();
        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (valueObject.value != 0) {//如果值不是0，就等待消费
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        valueObject.value = 1;
                        System.out.println("生产了，设置一个值");
                        lock.notifyAll();
                    }
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (valueObject.value != 0) {//如果值不是0，就等待消费
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        valueObject.value = 1;
                        System.out.println("生产了，设置一个值");
                        lock.notifyAll();
                    }
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (valueObject.value == 0) {//如果值是0，就等待生产者生产
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        valueObject.value = 0;
                        System.out.println("消费了，将值设置成0");
                        lock.notifyAll();
                    }
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (valueObject.value == 0) {//如果值是0，就等待生产者生产
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        valueObject.value = 0;
                        System.out.println("消费了，将值设置成0");
                        lock.notifyAll();
                    }
                }
            }
        }).start();
    }
}
