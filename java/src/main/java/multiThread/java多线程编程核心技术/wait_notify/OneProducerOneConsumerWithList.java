package multiThread.java多线程编程核心技术.wait_notify;

import java.util.ArrayList;
import java.util.List;

public class OneProducerOneConsumerWithList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Object lock = new Object();
        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (list.size() != 0) {//如果值不是0，就等待消费
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        list.add(1);
                        System.out.println("生产了，设置一个值" + ",listSize=" + list.size());
                        lock.notifyAll();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (list.size() == 0) {//如果值是0，就等待生产者生产
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        list.remove(0);
                        System.out.println("消费了，将值设置成0" + ",listSize=" + list.size());
                        lock.notifyAll();
                    }
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (list.size() == 0) {//如果值是0，就等待生产者生产
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        list.remove(0);
                        System.out.println("消费了，将值设置成0" + ",listSize=" + list.size());
                        lock.notifyAll();
                    }
                }
            }
        }).start();

    }
}
