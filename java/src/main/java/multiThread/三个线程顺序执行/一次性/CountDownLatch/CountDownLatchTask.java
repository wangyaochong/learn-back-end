package multiThread.三个线程顺序执行.一次性.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTask extends Thread {
    private final String name;
    private final CountDownLatch runCountDown;
    private final CountDownLatch otherStart;

    public CountDownLatchTask(String name, CountDownLatch runCountDown, CountDownLatch otherStart) {
        this.name = name;
        this.runCountDown = runCountDown;
        this.otherStart = otherStart;
    }

    @Override public void run() {
        try {
            if(this.runCountDown != null) {
                this.runCountDown.await();
            }
            System.out.println("start run " + this.name);
            Thread.sleep(1000);
            System.out.println("finish run " + this.name);
            if(this.otherStart != null) {
                this.otherStart.countDown();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
