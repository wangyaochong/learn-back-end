package multiThread.java高并发编程详解.第4章线程安全与同步;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class TestHashMap {
    static HashMap<String, String> map = new HashMap<>();

    public static void add(String key, String value) {
        map.put(key, value);
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                for (Integer j = 0; j < 10000; j++) {
                    add(j.toString() + Thread.currentThread().getId(), j.toString());
                }
                countDownLatch.countDown();
            });
            thread.start();
        }
        countDownLatch.await();
        System.out.println(map);
        System.out.println(map.size());//明显不是5万，并发情况数据会有丢失
    }
}
