package multiThread.三个线程顺序执行;

public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread hello = new Thread(() -> {
            try {
                Thread.sleep(1000L);
                System.out.println("hello");
                Thread.sleep(1000L);
                System.out.println("hello");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        hello.start();
        hello.join();
        System.out.println("main continue");
    }
}
