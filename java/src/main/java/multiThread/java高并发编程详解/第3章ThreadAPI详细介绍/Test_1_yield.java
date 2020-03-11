package multiThread.java高并发编程详解.第3章ThreadAPI详细介绍;

import java.util.stream.IntStream;

public class Test_1_yield {
    static class MyThread extends Thread {
        int index;

        MyThread(int index) {
            this.index = index;
        }

        @Override
        public void run() {
         /*   if (index == 0) {
                Thread.yield();
            }*/
            System.out.println(index);
        }
    }

    public static void main(String[] args) {
        IntStream.range(0, 10).mapToObj(MyThread::new).forEach(MyThread::start);
    }
}
