package multiThread.java多线程编程核心技术;

public class threadStop {
    static class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                for (int i = 0; i < 500000; i++) {
                    if (interrupted()) {
                        System.out.println("停滞状态，退出");
                        throw new InterruptedException("线程停止");
                    }
                    System.out.println("i=" + (i + 1));
                }
            } catch (InterruptedException e) {
                System.out.println("捕获异常，停止线程");
                e.printStackTrace();
            }
        }
    }

    static class MyThreadSleep extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                System.out.println("捕获异常，停止线程");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread = new MyThread();
        MyThreadSleep myThread = new MyThreadSleep();
        myThread.start();
        Thread.sleep(20);
        myThread.interrupt();
        System.out.println("end");
    }
}
