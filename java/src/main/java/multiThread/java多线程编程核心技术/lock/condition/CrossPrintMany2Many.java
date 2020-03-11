package multiThread.java多线程编程核心技术.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CrossPrintMany2Many {

    static class PrintService {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        boolean setFlag = false;

        public void set() {
            try {
                lock.lock();
                if (!setFlag) {
                    System.out.println("set");
                    setFlag = true;
                    Thread.sleep(1000);
                    condition.signalAll();
                } else {
                    condition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void get() {
            try {
                lock.lock();
                if (setFlag) {
                    System.out.println("get");
                    setFlag = false;
                    Thread.sleep(1000);
                    condition.signalAll();
                } else {
                    condition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadSet extends Thread {
        PrintService printService;

        ThreadSet(PrintService printService) {
            this.printService = printService;
        }

        @Override
        public void run() {
            super.run();
            while (true) {
                this.printService.set();
            }
        }
    }

    static class ThreadGet extends Thread {
        PrintService printService;

        ThreadGet(PrintService printService) {
            this.printService = printService;
        }

        @Override
        public void run() {
            super.run();
            while (true) {
                this.printService.get();
            }
        }
    }

    public static void main(String[] args) {
        PrintService printService = new PrintService();
        ThreadSet[] threadSets = new ThreadSet[10];
        ThreadGet[] threadGets = new ThreadGet[10];
        for (int i = 0; i < 10; i++) {
            threadGets[i] = new ThreadGet(printService);
            threadSets[i] = new ThreadSet(printService);
        }
        for (int i = 0; i < 10; i++) {
            threadGets[i].start();
            threadSets[i].start();
        }

    }
}
