package multiThread.example;

import java.util.concurrent.TimeUnit;

/**
 * @author wangyaochong
 * @date 2020/3/24 20:09
 */
public class 各种并发情况 {
    public static class Phone {

        public void hello() {
            System.out.println("hello");
        }

        public synchronized void sendEmailNoWaitSync() {
            System.out.println("发送邮件");
        }

        public synchronized void sendEmailSync() throws InterruptedException {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("发送邮件");
        }

        public synchronized void sendSmsSync() {
            System.out.println("发送短信");
        }

        public static synchronized void staticSendEmailSync() throws InterruptedException {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("发送邮件");
        }

        public static synchronized void staticSendSmsSync() {
            System.out.println("发送短信");
        }
    }

    //    什么都没有，结果随机
    public static void situation1() {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendEmailNoWaitSync();
        }).start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            phone.sendSmsSync();
        }).start();
    }

    //    邮件暂停3秒
    public static void situation2() {
        Phone phone = new Phone();
        new Thread(() -> {
            try {
                phone.sendEmailSync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            phone.sendSmsSync();
        }).start();
    }

    //    邮件暂停3秒
    public static void situation3() {
        Phone phone = new Phone();
        new Thread(() -> {
            try {
                phone.sendEmailSync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            phone.hello();
        }).start();
    }

    //    两部手机
    public static void situation4() {
        new Thread(() -> {
            try {
                Phone phone = new Phone();
                phone.sendEmailSync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            Phone phone = new Phone();
            phone.sendSmsSync();
        }).start();
    }

    //    一部手机，两个静态方法
    public static void situation5() {
        Phone phone = new Phone();
        new Thread(() -> {
            try {
                phone.staticSendEmailSync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            phone.staticSendSmsSync();
        }).start();
    }

    //    两部手机，两个静态方法
    public static void situation6() {
        new Thread(() -> {
            try {
                Phone phone = new Phone();
                phone.staticSendEmailSync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            Phone phone = new Phone();
            phone.staticSendSmsSync();
        }).start();
    }

    //    一部手机，一个静态方法
    public static void situation7() {
        Phone phone = new Phone();
        new Thread(() -> {
            try {
                phone.staticSendEmailSync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(phone::sendSmsSync).start();
    }

    //    两部手机，一个静态方法
    public static void situation8() {
        new Thread(() -> {
            try {
                Phone phone = new Phone();
                phone.staticSendEmailSync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            Phone phone = new Phone();
            phone.sendSmsSync();
        }).start();
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println("------同一个对象同一把锁，顺序打印-----没有暂停--------------");
        situation1();
        TimeUnit.SECONDS.sleep(4);
        System.out.println("------两个普通方法，一个对象，一把锁，顺序打印-------------------");
        situation2();
        TimeUnit.SECONDS.sleep(4);
        System.out.println("------两个普通方法，一个对象，没有加锁的不受影响-------------------");
        situation3();
        TimeUnit.SECONDS.sleep(4);
        System.out.println("-----两个普通方法，两个对象，两把锁--------------------");
        situation4();
        TimeUnit.SECONDS.sleep(4);
        System.out.println("--------两个静态方法，同一把锁-----------------");
        situation5();
        TimeUnit.SECONDS.sleep(4);
        System.out.println("-------两个静态方法，同一把锁------------------");
        situation6();
        TimeUnit.SECONDS.sleep(4);
        System.out.println("-------静态方法和普通方法不是同一把锁----一个对象------------------");
        situation7();
        TimeUnit.SECONDS.sleep(4);
        System.out.println("------静态方法和普通方法不是同一把锁----两个对象---------------");
        situation8();
    }
}
