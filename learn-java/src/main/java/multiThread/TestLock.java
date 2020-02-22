package multiThread;

import org.hibernate.Session;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;

public class TestLock {

    List<Integer> result = new ArrayList<>();
    List<Integer> result2 = new ArrayList<>();
    Map<Integer, Integer> mapResult = new HashMap<>();
    Map<Integer, Integer> mapResult2 = new HashMap<>();
    Object o = new Object();

    public void addToList(Integer x) {
        synchronized (o) {
            if (!result.contains(x)) {
                result.add(x);
            }
        }
//        List<Integer> integers = Arrays.asList(1, 2, 3);
        result2.addAll(Arrays.asList(x, x, x));
    }

    public void addToMap(int x) {
        mapResult.put(x, x);
        mapResult2.putAll(new HashMap<Integer, Integer>() {{
            put(x, x);
            put(x + 1, x);
        }});
    }


    @Test
    public void test() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    addToList(new Random().nextInt(5));
                    addToMap(new Random().nextInt(5));
                }
            });
        }

        TimeUnit.SECONDS.sleep(3);
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result2.size());
        System.out.println(mapResult);
        System.out.println(mapResult2);
        System.out.println(mapResult2.size());
    }

    @Test
    public void testMapAdd() {
    }

}
