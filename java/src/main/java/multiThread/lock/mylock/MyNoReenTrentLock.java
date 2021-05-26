package multiThread.lock.mylock;

public class MyNoReenTrentLock implements MyLock {
    private volatile boolean isLocked = false;

    public synchronized void lock() {
        while (isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
    }

    @Override
    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}
