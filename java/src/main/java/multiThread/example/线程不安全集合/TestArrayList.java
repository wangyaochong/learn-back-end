package multiThread.example.线程不安全集合;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyaochong
 * @date 2020/3/24 20:50
 */
public class TestArrayList {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        List<Thread> threadList = new ArrayList<>();
        List list = new ArrayList();
        for (int i = 0 ; i < threadCount ; i++) {
            threadList.add(new Thread(() -> {
                for (int j = 0 ; j < 100 ; j++) {
                    list.add(j);
                }
            }));
        }
        for (int i = 0 ; i < threadCount ; i++) {
            threadList.get(i).start();
        }
        Thread.sleep(3000);
        System.out.println(list.size());
        System.out.println(list);
    }
}
