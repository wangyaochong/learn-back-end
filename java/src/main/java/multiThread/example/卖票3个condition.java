package multiThread.example;

import lombok.Data;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个人卖票
 *
 * @author wangyaochong
 * @date 2020/3/24 17:45
 */
public class 卖票3个condition {
    @Data
    public static class Seller extends Thread {


        public static synchronized String getCurrentName() {
            return currentName;
        }

        public static synchronized void setCurrentName(String currentName) {
            Seller.currentName = currentName;
        }

        public static String currentName;
        volatile static int sellCount = 0;
        String sellerName;
        Lock lock;
        Condition sellCondition;
        Seller otherSeller;


        public Seller(String sellerName, int sellCount, Seller otherSeller) {
            super();
            this.sellCount = sellCount;
            this.sellerName = sellerName;
            this.otherSeller = otherSeller;
        }

        public Seller(String sellerName, int sellCount, Lock lock) {
            super();
            this.sellCount = sellCount;
            this.sellerName = sellerName;
            this.lock = lock;
            this.sellCondition = lock.newCondition();
        }


        @Override
        public void run() {
            while (sellCount > 0) {
                lock.lock();
                try {
                    while (!currentName.equals(sellerName)) {
                        sellCondition.await();
                    }
                    if (sellCount > 0) {
                        System.out.println(this.sellerName + " 卖票");
                        sellCount--;
                        System.out.println(this.sellerName + " 卖票结束,剩余:" + sellCount);
                    }
                    setCurrentName(otherSeller.getSellerName());
                    otherSeller.getSellCondition().signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Seller sellerA = new Seller("A", 30, lock);
        Seller sellerB = new Seller("B", 30, lock);
        Seller sellerC = new Seller("C", 30, lock);

        sellerA.setOtherSeller(sellerB);
        sellerB.setOtherSeller(sellerC);
        sellerC.setOtherSeller(sellerA);

        Seller.setCurrentName(sellerA.getSellerName());

        sellerA.start();
        sellerB.start();
        sellerC.start();


    }


}
