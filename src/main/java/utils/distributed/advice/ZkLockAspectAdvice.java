package utils.distributed.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import utils.distributed.annotation.ZkLock;
import utils.distributed.lock.ZKLock;

/**
 * @Description zk分布式锁切面
 * @Author lilong
 * @Date 2019-04-08 13:50
 */
@Aspect
public class ZkLockAspectAdvice {
    @Around(value = "@annotation(utils.distributed.annotation.ZkLock) && @annotation(zkLock)")
    public Object process(ProceedingJoinPoint pjp, ZkLock zkLock) throws Throwable {
        ZKLock lock = new ZKLock(zkLock.zkHost(), zkLock.bizType(), zkLock.lockKey());

        boolean acquired = false;
        try {
            acquired = lock.tryLock(zkLock.timeout());
            if (acquired) {
                return pjp.proceed();
            } else {
                System.out.println("######## 加锁失败，线程信息：" + Thread.currentThread().getId() + "-"
                        + Thread.currentThread().getName());
                return null;
            }
        } finally {
            if (acquired) {
                lock.unLock();
            }
        }
    }
}
