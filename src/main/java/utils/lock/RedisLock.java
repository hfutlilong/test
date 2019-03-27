package utils.lock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;

public class RedisLock {
    private static final String LOCK_MSG = "OK";
    private static final Long UNLOCK_MSG = 1L;

    private static final int DEFAULT_EXPIRE_TIME = 60 * 1000;
    private static final long DEFAULT_SLEEP_TIME = 100;

    private String redisIp = "192.168.160.128";
    private int redisPort = 6379;
    private JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), redisIp, redisPort);

    public RedisLock() {

    }

    public void lock(String key, String value) throws InterruptedException {
        Jedis jedis = jedisPool.getResource();
        while (true) {
            if (setLockToRedis(key, value, jedis)) {
                return;
            }
        }
    }

    public void lock(String key, String value, int timeout) throws InterruptedException {
        Jedis jedis = jedisPool.getResource();

        while (timeout >= 0) {
            if (setLockToRedis(key, value, jedis)) {
                return;
            }
            timeout -= DEFAULT_SLEEP_TIME;
        }
    }

    public boolean tryLock(String key, String value) throws InterruptedException {
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

        Thread.sleep(DEFAULT_SLEEP_TIME);
        return false;
    }

    public boolean unlock(String key, String value) {
        Jedis jedis = jedisPool.getResource();

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(key), Collections.singletonList(value));

        jedis.close();
        return UNLOCK_MSG.equals(result);
    }

    public boolean isLocked(String key) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.get(key);
        jedis.close();
        return result != null;
    }

    public void flushAll() {
        Jedis jedis = jedisPool.getResource();
        jedis.flushAll();
    }

}
