package multiThread.java多线程编程核心技术.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test {
    public static void main(String[] args) {
        Timer timer = new Timer(true);//可以通过构造参数设置是否为守护线程
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }, new Date());
    }

}
