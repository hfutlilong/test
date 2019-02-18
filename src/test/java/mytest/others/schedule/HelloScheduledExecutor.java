package mytest.others.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-02-15 19:15
 */
public class HelloScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        executor.schedule(new HelloTask(), 1, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(new HelloTask(), 3, 1, TimeUnit.SECONDS);
        executor.scheduleWithFixedDelay(new HelloTask(), 3, 1, TimeUnit.SECONDS);
    }
}
