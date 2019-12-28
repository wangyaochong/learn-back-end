package multiThread.java高并发编程详解.第2章深入理解Thread构造函数;

public class Test_1_线程组 {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1");
        ThreadGroup threadGroup = new ThreadGroup("testGroup");
        Thread t2 = new Thread(threadGroup, "t2");
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println(mainGroup);
        System.out.println(t1.getThreadGroup());
        System.out.println(t2.getThreadGroup());
    }
}
