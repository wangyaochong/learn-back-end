package multiThread.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyaochong
 * @date 2020/3/24 18:34
 */
public class 生产者消费者waitnotify {

    static volatile int resourceCount = 10;

    public static synchronized void descResource() {
        resourceCount--;
    }

    public static synchronized void incrResource() {
        resourceCount++;
    }

    public static class Consumer extends Thread {
        @Override
        public synchronized void run() {
            while (true) {
                while (resourceCount <= 0) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                descResource();
                System.out.println("消费一个，还剩" + resourceCount);
            }
        }
    }

    public static class Producer extends Thread {
        List<Consumer> consumerList;

        public Producer(List<Consumer> consumerList) {
            this.consumerList = consumerList;
        }

        @Override
        public void run() {
            while (true) {
                while (resourceCount < 5) {
                    incrResource();
                }
                System.out.println("生产了=" + resourceCount + "个");
                for (Consumer consumer : consumerList) {
                    synchronized (consumer) {
                        consumer.notify();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Consumer consumer1 = new Consumer();
        Consumer consumer2 = new Consumer();
        ArrayList<Consumer> consumerList = new ArrayList<>();
        consumerList.add(consumer1);
        consumerList.add(consumer2);
        Producer producer = new Producer(consumerList);
        producer.start();
        consumer1.start();
        consumer2.start();

    }

}
