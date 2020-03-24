package collection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author wangyaochong
 * @date 2020/3/24 21:55
 */
public class TestBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);
//        blockingQueue.add(1);
//        blockingQueue.add(2);
//        blockingQueue.add(3);
//        blockingQueue.add(4);
        Integer peek = blockingQueue.peek();
        System.out.println(peek);
        Integer element = blockingQueue.element();
        System.out.println(element);
    }
}
