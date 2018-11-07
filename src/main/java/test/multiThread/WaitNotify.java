package test.multiThread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WaitNotify {
    /**
     * 安全地终止线程
     */
    private static boolean flag = false;

    /**
     * 定义一把锁
     */
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        Thread.sleep(1000); //等一秒，等wait线程完全起来、进入等待

        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            //加锁，拥有对象lock的监视器Monitor
            synchronized (lock) {
                //当条件不满足时继续等待，同时释放lock上的锁
                while (flag) {
                    System.out.println(Thread.currentThread() + " flag is true,wait@"
                            + new SimpleDateFormat("HH:mm:ss").format(new Date()));

                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //当条件满足时，完成工作
                System.out.println(Thread.currentThread() + " flag is false,running@"
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock. notify@"
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));

                lock.notifyAll();
                flag = false;
                //通知完并不会立刻释放锁
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //到这里才释放锁
            }

            //此时如果再加锁，就需要跟其他线程竞争了
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again. sleep@"
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
