package multiThread.atest;

import java.util.concurrent.ArrayBlockingQueue;

public class TestBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);
        queue.put(1);
        System.out.println("插入1");
        queue.put(2);
        System.out.println("插入2");
    }
}
