package multiThread.java高并发编程详解.第1章快速认识线程;

public class Test_1_测试多次调用start方法 {
    public static void main(String[] args) throws InterruptedException {
        Thread hello = new Thread(() -> {
            System.out.println("hello");
        });
        hello.start();
//        Thread.sleep(1000);
        hello.start();


    }
}
