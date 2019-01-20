package mytest.redis.pubsub;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-01-20 17:33
 */

public class PubSubDemo {
    public static void main( String[] args ) {
        // 替换成你的reids地址和端口
        String redisIp = "192.168.160.128";
        int redisPort = 6379;
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), redisIp, redisPort);
        System.out.println(String.format("redis pool is starting, redis ip %s, redis port %d", redisIp, redisPort));

        SubThread subThread = new SubThread(jedisPool);
        subThread.start();

        Publisher publisher = new Publisher(jedisPool);
        publisher.start();
    }
}