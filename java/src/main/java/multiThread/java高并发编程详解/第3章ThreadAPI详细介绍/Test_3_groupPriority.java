package multiThread.java高并发编程详解.第3章ThreadAPI详细介绍;

public class Test_3_groupPriority {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("testCoreSize");
        threadGroup.setMaxPriority(7);
        Thread thread = new Thread(threadGroup, () -> System.out.println("hello"));
        thread.setPriority(10);
        System.out.println(thread.getPriority());
    }
}
