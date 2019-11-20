package multiThread.volatile_;

public class TestVolatile {
    private static Boolean isContinue = true;
//    private static volatile boolean isContinue = true;

    static public void printStringMethod() {
        while (isContinue) {//如果不使用volatile关键字，则会进入死循环

        }
        System.out.println("停止了");
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            printStringMethod();
        }).start();
        Thread.sleep(1000);
        isContinue = false;
    }
}
