package mytest.redis;

import mytest.base.BaseTest;
import org.testng.annotations.Test;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import utils.lock.RedisLock;


/**
 * @Description 分布式锁的测试
 * @Author lilong
 * @Date 2019-03-27 20:38
 */
public class RedisLockTest extends BaseTest {
    private String redisIp = "192.168.160.128";
    private int redisPort = 6379;
    private JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), redisIp, redisPort);
    private RedisLock redisLock = new RedisLock(jedisPool);

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
