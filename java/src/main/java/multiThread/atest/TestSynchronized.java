package multiThread.atest;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wangyaochong
 * @date 2020/3/27 23:43
 */
public class TestSynchronized {
    int i = 0;

    public synchronized void test() {
        i++;
    }

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();

        AtomicLong atomicLong = new AtomicLong();
        atomicLong.incrementAndGet();
    }
}
