package multiThread;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestHashMapGet {

    @Test
    public void test() {
        /**
         * 哈希map在多线程访问时不会有并发问题
         */
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < 500; i++) {
            result.put(i, i);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10000; i++) {
            int finalI = i;
            executorService.execute(
                    () -> {
                        System.out.println(result.get(finalI % 500));
                    });
        }
    }
}
