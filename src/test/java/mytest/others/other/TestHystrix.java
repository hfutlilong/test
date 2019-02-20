package mytest.others.other;

import com.netflix.hystrix.HystrixCommand;
import mytest.base.BaseTest;
import org.testng.annotations.Test;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-02-19 17:21
 */
public class TestHystrix extends BaseTest {

    @Test
    public void testCircuitBreaker() throws Exception{
        for(int i=0;i<25;i++){
            Thread.sleep(500);
            HystrixCommand<String> command = new SimpleHystrix("testCircuitBreaker");
            String result = command.execute();
            //本例子中从第11次，熔断器开始打开
            System.out.println("call times:"+(i+1)+"   result:"+result +" isCircuitBreakerOpen: "+command.isCircuitBreakerOpen());
            //本例子中5s以后，熔断器尝试关闭，放开新的请求进来
        }

        System.out.println("我要休息，休息一会儿！");
        Thread.sleep(10000);

        for(int i=0;i<25;i++){
            Thread.sleep(500);
            HystrixCommand<String> command = new SimpleHystrix("testCircuitBreaker");
            String result = command.execute();
            //本例子中从第11次，熔断器开始打开
            System.out.println("call times:"+(i+1)+"   result:"+result +" isCircuitBreakerOpen: "+command.isCircuitBreakerOpen());
            //本例子中5s以后，熔断器尝试关闭，放开新的请求进来
        }
    }
}
