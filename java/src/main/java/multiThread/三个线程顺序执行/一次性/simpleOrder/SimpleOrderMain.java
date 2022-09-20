package multiThread.三个线程顺序执行.一次性.simpleOrder;

public class SimpleOrderMain {
    public static void main(String[] args) {
        Thread t3 = new Thread(new SimpleOrderTask("t3", null));
        Thread t2 = new Thread(new SimpleOrderTask("t2", t3));
        Thread t1 = new Thread(new SimpleOrderTask("t1", t2));
        t1.start();
    }
}
