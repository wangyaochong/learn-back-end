package multiThread.lock.mylock;

public class MyReenTrentLock implements MyLock {
    private volatile Boolean isLocked = false;
    private volatile long lockThreadId = 0L;
    private volatile int lockCount = 0;

    @Override
    public synchronized void lock() {
        long curThreadId = Thread.currentThread().getId();
        while (isLocked && lockThreadId != curThreadId) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        lockThreadId = curThreadId;
        lockCount++;
    }

    @Override
    public synchronized void unlock() {
        long curThreadId = Thread.currentThread().getId();
        if (curThreadId == lockThreadId) {
            lockCount--;
            if (lockCount == 0) {
                isLocked = false;
                notify();
            }
        }
    }
}
