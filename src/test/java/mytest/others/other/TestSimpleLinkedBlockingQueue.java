package mytest.others.other;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-01-27 20:45
 */
public class TestSimpleLinkedBlockingQueue {
    private static SimpleLinkedBlockingQueue<Integer> queue = new SimpleLinkedBlockingQueue<>(3);
    private static AtomicInteger ai = new AtomicInteger();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        queue.put(ai.getAndIncrement());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        //打印队列现有元素
                        System.out.println(queue);
                        Integer e = queue.take();
                        System.out.println(e);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
