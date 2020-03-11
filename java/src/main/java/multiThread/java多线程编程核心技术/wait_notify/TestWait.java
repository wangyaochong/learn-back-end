package multiThread.java多线程编程核心技术.wait_notify;

public class TestWait {
    public static void main(String[] args) throws InterruptedException {
        String newString = "123";
//        synchronized (newString) {//如果不先获取到对象锁，调用wait会导致
        newString.wait();
//        }
        System.out.println("finish");
    }
}
