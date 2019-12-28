package multiThread.java高并发编程详解.第1章快速认识线程;

public class Test_2_模拟叫号 {
    static class TicketWindow implements Runnable {
        int count = 0;
        int maxCount = 50000;

        @Override
        public void run() {
            while (count < maxCount) {
                System.out.println("当前叫号=" + count++ + ",thread=" + Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        TicketWindow ticketWindow = new TicketWindow();
        for (int i = 0; i < 8; i++) {
            Thread thread = new Thread(ticketWindow);
            thread.setName("窗口" + i);
            thread.start();
        }
    }
}
