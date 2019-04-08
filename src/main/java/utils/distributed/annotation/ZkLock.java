package utils.distributed.annotation;

import java.lang.annotation.*;

/**
 * ZK分布式锁注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ZkLock {
    /**
     * zk地址
     * @return
     */
    String zkHost();

    /**
     * 业务类型
     */
    String bizType();

    /**
     * 锁名称
     *
     * @return
     */
    String lockKey();

    /**
     * 超时时间
     * @return
     */
    long timeout();
}