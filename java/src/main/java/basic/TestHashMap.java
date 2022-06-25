package basic;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author wangyaochong
 * @date 2020/3/29 22:48
 */
public class TestHashMap {
    public static void main(String[] args) throws InterruptedException {
        int count = 10000000;
        Map<String, Object> map = new ConcurrentHashMap<>(count);
        for (int i = 0; i < count; i++) {
            map.put(UUID.randomUUID().toString(), new Random().nextDouble());
            System.out.println(map.size());
        }
        TimeUnit.SECONDS.sleep(10000);
    }


    //测试LinkedHashMap的有序性
    @Test
    public void testLinkedHashMap() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("1", "1");
        linkedHashMap.put("2", "1");
        linkedHashMap.put("3", "1");
        linkedHashMap.put("0", "1");
        System.out.println(linkedHashMap);

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "1");
        hashMap.put("2", "1");
        hashMap.put("3", "1");
        hashMap.put("0", "1");
        System.out.println(hashMap);
    }
}
