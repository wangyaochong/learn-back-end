package multiThread.java高并发编程详解.第3章ThreadAPI详细介绍;

public class Test_2_priority {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            int count = 0;
            while (true) {
                System.out.println("t1," + count++);
            }
        });
        t1.setPriority(1);
        Thread t2 = new Thread(() -> {
            int count = 0;
            while (true) {
                System.out.println("t2," + count++);
            }
        });
        t2.setPriority(10);//可以看到优先级越大，打印次数越多，优先级的取值范围在1-10
//        t1.start();
//        t2.start();
        System.out.println(t1.getThreadGroup().getMaxPriority());
        System.out.println(t2.getThreadGroup().getMaxPriority());
    }
}
