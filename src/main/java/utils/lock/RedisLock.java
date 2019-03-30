package utils.lock;

import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;
import java.util.UUID;

public class RedisLock {
    /**
     * 每个线程持有自己的uuid，用于区分不同的锁
     */
    private static final ThreadLocal<String> identifier = ThreadLocal.withInitial(() -> UUID.randomUUID().toString());

    private static final String LOCK_MSG = "OK";
    private static final Long UNLOCK_MSG = 1L;

    /**
     * 锁过期时间默认值
     */
    private static final int DEFAULT_EXPIRE_TIME = 60;

    /**
     * 阻塞式获取锁的间隔时间
     */
    private static final long DEFAULT_SLEEP_TIME = 100;

    // Redis连接池
    private static String REDIS_IP = "192.168.160.128";
    private static int REDIS_PORT = 6379;
    private static JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), REDIS_IP, REDIS_PORT);

    // 加锁的键
    private String lockKey;

    // 重入锁计数器
    private int counter = 0;

    public RedisLock(String lockKey) {
        this.lockKey = lockKey;
    }


    /*******************************************
     * 锁对外提供的使用方法
     *******************************************/

    /**
     * 阻塞式锁，尝试获取锁、直到成功
     * @throws InterruptedException
     */
    public void lock() throws InterruptedException {
        lock(lockKey, identifier.get());
    }

    /**
     * 非阻塞式锁，只尝试一次，无论是否获取到锁都返回
     * @return
     * @throws InterruptedException
     */
    public boolean tryLock() throws InterruptedException {
        return tryLock(lockKey, identifier.get());
    }

    /**
     * 阻塞式锁，在超时时间内尝试获取锁，默认100ms尝试一次
     * @param timeout
     * @return
     * @throws InterruptedException
     */
    public boolean tryLock(int timeout) throws InterruptedException {
        return tryLock(lockKey, identifier.get(), timeout);
    }

    public boolean unlock() {
        return unlock(lockKey, identifier.get());
    }

    public boolean isLocked() {
        Jedis jedis = jedisPool.getResource();
        String redisVal = jedis.get(lockKey);
        return redisVal != null && redisVal.equals(identifier.get());
    }

    public void flushAll() {
        Jedis jedis = jedisPool.getResource();
        jedis.flushAll();
    }

    public void shutdown() {
        jedisPool.destroy();
    }


    /*******************************************
     * 以下是锁的内部实现
     *******************************************/
    private void lock(String key, String value) throws InterruptedException {
        Jedis jedis = jedisPool.getResource();
        while (true) {
            if (setLockToRedis(key, value, jedis)) {
                return;
            }
        }
    }

    private boolean tryLock(String key, String value, int timeout) throws InterruptedException {
        Jedis jedis = jedisPool.getResource();

        while (timeout >= 0) {
            if (setLockToRedis(key, value, jedis)) {
                return true;
            }
            timeout -= DEFAULT_SLEEP_TIME;
        }

        return false;
    }

    private boolean tryLock(String key, String value) throws InterruptedException {
        Jedis jedis = jedisPool.getResource();
        return setLockToRedis(key, value, jedis);
    }

    private boolean setLockToRedis(String key, String value, Jedis jedis) throws InterruptedException {
        SetParams params = new SetParams();
        params.nx().ex(DEFAULT_EXPIRE_TIME); // setNx，带超时时间

        String result = jedis.set(key, value, params);
        if (LOCK_MSG.equals(result)) {
            jedis.close();
            return true;
        }

        // 重入
        String redisVal = jedis.get(key);
        if (StringUtils.isNotBlank(redisVal) && redisVal.equals(value)) {
            counter++;
            jedis.close();
            return true;
        }

        Thread.sleep(DEFAULT_SLEEP_TIME);
        return false;
    }

    private boolean unlock(String key, String value) {
        if (counter > 0) {
            counter--;
            return true;
        }


        Jedis jedis = jedisPool.getResource();

        // 只有缓存的value和方法入参value相等时才删除缓存，保证只有加锁的线程有权限解锁
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(key), Collections.singletonList(value));

        jedis.close();
        return UNLOCK_MSG.equals(result);
    }

}
