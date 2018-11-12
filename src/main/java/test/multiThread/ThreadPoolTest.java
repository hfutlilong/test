package test.multiThread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 线程池小测试
 * @Author lilong
 * @Date 2018-11-10 17:40
 */
public class ThreadPoolTest {
    private static AtomicInteger ai = new AtomicInteger();

    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return -1;
        }
    };

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 8,
                30, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        //空闲线程可以存活30s，我们趁热使用上一个线程
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    int tmp = ai.getAndIncrement();
                    threadLocal.set(tmp);
                    System.out.println(Thread.currentThread().getId() + "#" + Thread.currentThread().getName() + "::"
                            + threadLocal.get() + ", set::" + tmp);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        for (int i = 0; i < 8; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getId() + "#" + Thread.currentThread().getName() + "::"
                            + threadLocal.get());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}
