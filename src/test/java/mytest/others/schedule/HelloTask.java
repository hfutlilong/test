package mytest.others.schedule;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-02-15 19:14
 */
public class HelloTask implements Runnable {
    public void run() {
        System.out.println("hello world");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
