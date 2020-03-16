package multiThread.java高并发编程详解.第12章volatile关键字的介绍;

import java.util.concurrent.TimeUnit;

public class VolatileVisibility1 {
    final static int MAX = 5;
    static volatile Integer init_value = 0;//不加上volatile，另一个线程无法感知到值的更新

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = init_value;
            while (localValue < MAX) {
                if (init_value != localValue) {
                    System.out.printf("init value is updated to [%d]\n", init_value);
                    localValue = init_value;
                }
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            System.out.println("reader结束");
        }, "reader").start();
        new Thread(() -> {
            int localValue = init_value;
            while (localValue < MAX) {
                System.out.printf("the init_value will be changed to [%d]\n", ++localValue);
                init_value = localValue;
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("writer结束");
        }, "writer").start();
    }
}
