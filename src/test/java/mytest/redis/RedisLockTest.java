package mytest.redis;

import mytest.base.BaseTest;
import org.testng.annotations.Test;
import utils.lock.RedisLock;


/**
 * @Description 分布式锁的测试
 * @Author lilong
 * @Date 2019-03-27 20:38
 */
public class RedisLockTest extends BaseTest {
    private RedisLock redisLock = new RedisLock();

    @Test
    public void testLock() {
        try {
            redisLock.lock("业务名+方法名", "ip+线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            redisLock.unlock("业务名+方法名", "ip+线程");
        }
    }
}
