package utils.lock;

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
    private static final ThreadLocal<String> threadLocalUuid = ThreadLocal.withInitial(() -> UUID.randomUUID().toString());

    private static final String LOCK_MSG = "OK";
    private static final Long UNLOCK_MSG = 1L;

    /**
     * 锁过期时间默认值
     */
    private static final int DEFAULT_EXPIRE_TIME = 60 * 1000;

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
    public void lock() throws InterruptedException {
        lock(lockKey, threadLocalUuid.get());
    }

    public void lock(int timeout) throws InterruptedException {
        lock(lockKey, threadLocalUuid.get(), timeout);
    }

    public boolean tryLock() throws InterruptedException {
        return tryLock(lockKey, threadLocalUuid.get());
    }

    public boolean unlock() {
        return unlock(lockKey, threadLocalUuid.get());
    }

    public boolean isLocked() {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.get(lockKey);
        jedis.close();
        return result != null;
    }

    public void flushAll() {
        Jedis jedis = jedisPool.getResource();
        jedis.flushAll();
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

    private void lock(String key, String value, int timeout) throws InterruptedException {
        Jedis jedis = jedisPool.getResource();

        while (timeout >= 0) {
            if (setLockToRedis(key, value, jedis)) {
                return;
            }
            timeout -= DEFAULT_SLEEP_TIME;
        }
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
        params = new SetParams();
        params.xx().ex(DEFAULT_EXPIRE_TIME); // setNx，带超时时间
        result = jedis.set(key, value, params);
        if (LOCK_MSG.equals(result)) {
            counter++;
            jedis.close();
            return true;
        }

        Thread.sleep(DEFAULT_SLEEP_TIME);
        return false;
    }

    private boolean unlock(String key, String value) {
        Jedis jedis = jedisPool.getResource();

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(key), Collections.singletonList(value));

        jedis.close();
        return UNLOCK_MSG.equals(result);
    }

}
