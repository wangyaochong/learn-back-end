package multiThread.java多线程编程核心技术.wait_notify;

import org.junit.Test;

public class TestWait {
    @Test
    public void testOnlyNotify() {
        Object obj = new Object();
        synchronized (obj) {
            obj.notify();//等待3秒
        }
        System.out.println("直接调用notify");
    }

    @Test
    public void test() throws InterruptedException {
        Object obj = new Object();
        synchronized (obj) {
            System.out.println("等待3秒");
            obj.wait(3000);//等待3秒
        }
        System.out.println("等待时间结束");
    }

    public static void main(String[] args) throws InterruptedException {
        String newString = "123";
        new Thread(() -> {
            try {
                System.out.println("等待3秒");
                Thread.sleep(3000);
                System.out.println("等待结束，唤醒线程");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (newString) {//需要使用synchronized关键字修饰
                newString.notify();
            }
        }).start();
        synchronized (newString) {
            System.out.println("线程开始等待");
            newString.wait();
        }
        System.out.println("finish");
    }
}
