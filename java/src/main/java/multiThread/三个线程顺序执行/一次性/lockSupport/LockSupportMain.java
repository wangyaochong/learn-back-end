package multiThread.三个线程顺序执行.一次性.lockSupport;

public class LockSupportMain {
    public static void main(String[] args) {
        LockSupportTask t3 = new LockSupportTask("t3", true,null);
        LockSupportTask t2 = new LockSupportTask("t2", true,t3);
        LockSupportTask t1 = new LockSupportTask("t1", false,t2);
        t1.start();
        t2.start();
        t3.start();
    }
}
