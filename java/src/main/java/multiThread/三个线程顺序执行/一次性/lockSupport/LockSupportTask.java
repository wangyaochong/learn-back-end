package multiThread.三个线程顺序执行.一次性.lockSupport;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTask extends Thread {
    private final String name;
    private final Thread next;
    private final Boolean needPark;

    public LockSupportTask(String name, Boolean needPark, Thread next) {
        this.name = name;
        this.next = next;
        this.needPark = needPark;
    }

    @Override
    public void run() {
        try {
            if (needPark) {
                LockSupport.park();
            }
            System.out.println("start run " + this.name);
            Thread.sleep(1000);
            System.out.println("finish run " + this.name);
            if (next != null) {
                LockSupport.unpark(next);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
