package mytest.others.other;

import com.google.common.cache.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Description 学习guava cache
 * @Author lilong
 * @Date 2019-01-20 11:48
 */
public class TestGuavaCache {
    public static void main(String[] args) {
        try {
            useCacheLoader();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法1：使用cacheLoader加载缓存
     * @throws InterruptedException
     * @throws ExecutionException
     */
    private static void useCacheLoader() throws InterruptedException, ExecutionException {
        LoadingCache<Integer, String> strCache = CacheBuilder.newBuilder()
                .concurrencyLevel(8) //并发级别为8，可以有8个线程同时写缓存
                .expireAfterWrite(4, TimeUnit.SECONDS) //写缓存后8秒钟过期
//                .expireAfterAccess(8, TimeUnit.SECONDS)
//                .refreshAfterWrite(4, TimeUnit.SECONDS)
                .initialCapacity(10) //缓存容器初始容量为10
                .maximumSize(100) //缓存最大容量100，超过100按LRU淘汰
                .recordStats() //统计缓存命中率
                .removalListener(new RemovalListener<Object, Object>() { //缓存移除通知
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                        System.out.println(notification.getKey() + " was removed, cause is " + notification.getCause());
                    }
                }).build(
                        //指定CacheLoader，当缓存不存在时自动加载
                        new CacheLoader<Integer, String>() {
                            @Override
                            public String load(Integer key) throws Exception {
                                System.out.println("load data: " + key);
                                String str = key + ":cache-value";
                                return str;
                            }
                        }
                );

        for (int i = 0; i < 20; i++) {
            String str = strCache.get(1);
            System.out.println(str);
            Thread.sleep(1000);
        }

        System.out.println("cache status:" + strCache.stats().toString());
    }

    /**
     * 使用Callable方式加载缓存
     */
    private static void useCallable() throws ExecutionException {
        Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(100).build();
        String resultVal = cache.get("test", new Callable<String>() {
            @Override
            public String call() {
                String strProValue = "test-value";
                System.out.println("load new value: " + strProValue);
                return strProValue;
            }
        });

        System.out.println("return value: " + resultVal);
        System.out.println("return value: " + resultVal);
    }
}
