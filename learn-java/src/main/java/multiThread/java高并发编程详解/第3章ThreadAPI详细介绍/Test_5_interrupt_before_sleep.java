package multiThread.java高并发编程详解.第3章ThreadAPI详细介绍;

import java.util.concurrent.TimeUnit;

public class Test_5_interrupt_before_sleep {
    public static void main(String[] args) {
        System.out.println(Thread.interrupted());
        Thread.currentThread().interrupt();
//        System.out.println(Thread.interrupted());如果加上这行，会清除中断标记，则会睡眠5秒
        System.out.println(Thread.currentThread().isInterrupted());
        try {
            TimeUnit.SECONDS.sleep(5);//睡眠不足5秒，直接被中断
        } catch (InterruptedException e) {
            System.out.println("被中断了");
            e.printStackTrace();
        }
        System.out.println("结束");
    }
}
