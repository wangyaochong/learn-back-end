package basic;

import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author wangyaochong
 * @date 2020/3/29 22:48
 */
public class TestHashMap {
    public static void main(String[] args) throws InterruptedException {
        int count=10000000;
        Map<String, Object> map = new ConcurrentHashMap<>(count);
        for (int i = 0 ; i < count ; i++) {
            map.put(UUID.randomUUID().toString(), new Random().nextDouble());
            System.out.println(map.size());
        }
        TimeUnit.SECONDS.sleep(10000);
    }
}
