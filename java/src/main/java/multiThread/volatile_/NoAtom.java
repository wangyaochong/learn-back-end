package multiThread.volatile_;

import java.util.concurrent.atomic.AtomicInteger;

public class NoAtom {
    static class MyThread extends Thread {
        //        volatile public static int count = 0;
        public static AtomicInteger count = new AtomicInteger(0);//使用原子类不使用synchronized关键词也可以保持同步

        private static void addCount() {//这个地方加上synchronized就能保证最终count=10000，volatile不具有原子性
            for (int i = 0; i < 100; i++) {
//                count++;
                count.incrementAndGet();
            }
            System.out.println("count=" + count);
        }

        @Override
        public void run() {
            super.run();
            addCount();
        }
    }

    public static void main(String[] args) {
        MyThread[] myThreads = new MyThread[100];
        for (int i = 0; i < 100; i++) {
            myThreads[i] = new MyThread();
        }
        for (int i = 0; i < 100; i++) {
            myThreads[i].start();
        }
    }
}
