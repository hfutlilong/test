package mytest.others.other;

import com.netflix.hystrix.*;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wangxindong on 2017/8/15.
 */
public class SimpleHystrix extends HystrixCommand<String> {
    public SimpleHystrix(String name){
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ThreadPoolTestGroup"))
                        .andCommandKey(HystrixCommandKey.Factory.asKey("testCommandKey"))
                        .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey(name))
                        .andCommandPropertiesDefaults(
                                HystrixCommandProperties.Setter()
                                        .withCircuitBreakerEnabled(true)//默认是true，本例中为了展现该参数
                                        .withCircuitBreakerForceOpen(false)//默认是false，本例中为了展现该参数
                                        .withCircuitBreakerForceClosed(false)//默认是false，本例中为了展现该参数
                                        .withCircuitBreakerErrorThresholdPercentage(10)//(1)错误百分比超过10%
                                        .withCircuitBreakerRequestVolumeThreshold(10)//(2)10s以内调用次数10次，同时满足(1)(2)熔断器打开
                                        .withCircuitBreakerSleepWindowInMilliseconds(5000)//隔5s之后，熔断器会尝试半开(关闭)，重新放进来请求
                        )
                        .andThreadPoolPropertiesDefaults(
                                HystrixThreadPoolProperties.Setter()
                                        .withMaxQueueSize(10)   //配置队列大小
                                        .withCoreSize(2)    // 配置线程池里的线程数
                        )
        );
    }

    @Override
    protected String run() throws Exception {
        int i = TestHystrix.ai.getAndIncrement();
        // 10s内达到熔断条件
        if (i < 10) {
            Thread.sleep(500);
            throw new NullPointerException();
        }

        Thread.sleep(500);
        return "success";
    }

    @Override
    protected String getFallback() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "fail";
    }
}