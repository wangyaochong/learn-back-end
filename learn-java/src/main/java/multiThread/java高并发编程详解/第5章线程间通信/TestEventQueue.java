package multiThread.java高并发编程详解.第5章线程间通信;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TestEventQueue {
    @Test
    public void testRight() {

    }

    @Test
    public void testWrong() throws InterruptedException {
        EventQueueWrong eventQueueWrong = new EventQueueWrong();
        new Thread(() -> {
            while (true) {
                eventQueueWrong.offer("event");
                System.out.println("add event");
            }
        }).start();
        new Thread(() -> {
            while (true) {
                String take = eventQueueWrong.take();
                System.out.println("consume event");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        TimeUnit.SECONDS.sleep(1000);
    }

    @Test
    public void testWrong2() throws InterruptedException {
        EventQueueWrong eventQueueWrong = new EventQueueWrong();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                while (true) {
                    eventQueueWrong.offer("event");
                    System.out.println("add event");
                }
            }).start();
        }
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                while (true) {
                    String take = eventQueueWrong.take();
                    System.out.println("consume event");

                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(1000);
    }

    @Test
    public void testRight2() throws InterruptedException {
        EventQueueRight eventQueueWrong = new EventQueueRight();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                while (true) {
                    eventQueueWrong.offer("event");
                    System.out.println("add event");
                }
            }).start();
        }
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                while (true) {
                    String take = eventQueueWrong.take();
                    System.out.println("consume event");

                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(1000);
    }
}
