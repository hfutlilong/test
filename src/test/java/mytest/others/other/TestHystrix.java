package mytest.others.other;

import com.netflix.hystrix.HystrixCommand;
import mytest.base.BaseTest;
import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-02-19 17:21
 */
public class TestHystrix extends BaseTest {
    public static final AtomicInteger ai = new AtomicInteger();

    @Test
    public void testCircuitBreaker() throws Exception{
        for(int i = 0; i < 20; i++) {
            HystrixCommand<String> command = new SimpleHystrix("testCircuitBreaker");
            String result = command.execute();
            //本例子中从第11次，熔断器开始打开
            System.out.println("call times:"+ i +"   result:" + result + " isCircuitBreakerOpen: " + command.isCircuitBreakerOpen());
        }

        // 5s 之后熔断器半开
        Thread.sleep(8000);
        System.out.println("===============================");

        for(int i = 0; i < 20; i++) {
            HystrixCommand<String> command = new SimpleHystrix("testCircuitBreaker");
            String result = command.execute();
            //本例子中从第11次，熔断器开始打开
            System.out.println("call times:"+ i +"   result:" + result + " isCircuitBreakerOpen: " + command.isCircuitBreakerOpen());
        }

        System.out.println("===============================");
        ai.set(0);
        for(int i = 0; i < 20; i++) {
            HystrixCommand<String> command = new SimpleHystrix("testCircuitBreaker");
            String result = command.execute();
            //本例子中从第11次，熔断器开始打开
            System.out.println("call times:"+ i +"   result:" + result + " isCircuitBreakerOpen: " + command.isCircuitBreakerOpen());
        }
    }
}
