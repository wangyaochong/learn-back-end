package multiThread.三个线程顺序执行.一次性.Join;

public class JoinMain {
    public static void main(String[] args) {
        JoinTask t1 = new JoinTask("t1", null);
        JoinTask t2 = new JoinTask("t2", t1);
        JoinTask t3 = new JoinTask("t3", t2);
        t1.start();
        t2.start();
        t3.start();
    }
}
