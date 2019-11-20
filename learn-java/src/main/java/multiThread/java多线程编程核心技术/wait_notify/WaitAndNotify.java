package multiThread.java多线程编程核心技术.wait_notify;

public class WaitAndNotify {
    public static void main(String[] args) {
        final String lock = "";
        new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("开始等待1");
                    lock.wait();
                    System.out.println("结束等待1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("开始等待2");
                    lock.wait();
                    System.out.println("结束等待2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(1000);
                    System.out.println("开始通知");
                    //  lock.notify();
                    lock.notifyAll();//如果是notify，只能唤醒一个线程，如果是notifyAll，则可以把该对象下所有wait的线程都唤醒
                    System.out.println("等待1秒");
                    Thread.sleep(1000);//这行代码可以说明，必须等到lock对象锁释放后，wait代码才能恢复运行
                    System.out.println("结束通知");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
