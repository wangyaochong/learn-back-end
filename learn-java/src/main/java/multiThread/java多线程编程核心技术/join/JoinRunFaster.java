package multiThread.java多线程编程核心技术.join;

public class JoinRunFaster {
    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            try {
                System.out.println("thread start");
                Thread.sleep(5000);
                System.out.println("thread finish");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.join(2000);
        System.out.println("main finish");
    }
}
