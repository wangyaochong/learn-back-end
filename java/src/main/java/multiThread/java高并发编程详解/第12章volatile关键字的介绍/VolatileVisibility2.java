package multiThread.java高并发编程详解.第12章volatile关键字的介绍;

import lombok.Data;

public class VolatileVisibility2 {

    static volatile MyNumber myNumber = new MyNumber();

    @Data
    static class MyNumber {
        int number;
    }

    public static void main(String[] args) {
        myNumber.number = 10;
        new Thread(() -> {
            try {
                System.out.println("等待1秒");
                Thread.sleep(1000);
                myNumber.number = 11;
                System.out.println("子线程结束了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        while (myNumber.number == 10) {

        }
        System.out.println("主线程结束了");
    }
}
