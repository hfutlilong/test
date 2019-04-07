package mytest.distributed.lock;

import utils.distributed.lock.RedisLock;

import java.util.concurrent.*;


/**
 * @Description 分布式锁的测试
 * @Author lilong
 * @Date 2019-03-27 20:38
 */
public class RedisLockTest {
    public static void main(String[] args) {
        RedisLock redisLock = new RedisLock("testLock");

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 0; i < 1; i++) {
            threadPool.execute(() -> {
                try {
                    testBlockedLock(redisLock);
                    System.out.println("######### " + Thread.currentThread().getId() + " 馍馍片");
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Game Over!");
        threadPool.shutdown();
        redisLock.flushAll(); // 清空缓存
    }

    /**
     * 阻塞式锁
     *
     * @param redisLock
     * @throws InterruptedException
     */
    private static void testBlockedLock(RedisLock redisLock) throws InterruptedException {
        System.out.println("######### " + Thread.currentThread().getId() + " 加锁中...");
        redisLock.lock();
        boolean isLocked = redisLock.isLocked();

        try {
            System.out.println("######### " + Thread.currentThread().getId() + (isLocked ? " 加锁成功！" : " 加锁失败！"));
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (redisLock.unlock()) {
                System.out.println("######### " + Thread.currentThread().getId() + " 解锁成功");
            } else {
                System.out.println("######### " + Thread.currentThread().getId() + " 解锁失败");
            }
        }
    }

    /**
     * 非阻塞式锁
     *
     * @param redisLock
     * @throws InterruptedException
     */
    private static void testNonBlockingLock(RedisLock redisLock) throws InterruptedException {
        System.out.println("######### " + Thread.currentThread().getId() + " 加锁中...");
        boolean isLocked = redisLock.tryLock();

        try {
            System.out.println("######### " + Thread.currentThread().getId() + (isLocked ? " 加锁成功！" : " 加锁失败！"));
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (redisLock.unlock()) {
                System.out.println("######### " + Thread.currentThread().getId() + " 解锁成功");
            } else {
                System.out.println("######### " + Thread.currentThread().getId() + " 解锁失败");
            }
        }
    }

    /**
     * 带超时时间的阻塞式锁
     *
     * @param redisLock
     * @throws InterruptedException
     */
    private static void testBlockedLockWithTimeout(RedisLock redisLock) throws InterruptedException {
        System.out.println("######### " + Thread.currentThread().getId() + " 加锁中...");
        boolean isLocked = redisLock.tryLock(1000);

        try {
            System.out.println("######### " + Thread.currentThread().getId() + (isLocked ? " 加锁成功！" : " 加锁失败！"));
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (redisLock.unlock()) {
                System.out.println("######### " + Thread.currentThread().getId() + " 解锁成功");
            } else {
                System.out.println("######### " + Thread.currentThread().getId() + " 解锁失败");
            }
        }
    }

    /**
     * 重入锁
     *
     * @param redisLock
     * @throws InterruptedException
     */
    private static void testReentrantLock(RedisLock redisLock) {
        int i = 1;
        try {
            System.out.println("######### " + Thread.currentThread().getId() + " 第" + i +  "次加锁中...");
            redisLock.lock();
            boolean isLocked = redisLock.isLocked();
            System.out.println("######### " + Thread.currentThread().getId() + " 第" + i + "次" +(isLocked ? "加锁成功！" : "加锁失败！"));
            Thread.sleep(1000);

            i++;
            System.out.println("######### " + Thread.currentThread().getId() + " 第" + i +  "次加锁中...");
            redisLock.lock();
            isLocked = redisLock.isLocked();
            System.out.println("######### " + Thread.currentThread().getId() + " 第" + i + "次" +(isLocked ? "加锁成功！" : "加锁失败！"));
            Thread.sleep(1000);

            i++;
            System.out.println("######### " + Thread.currentThread().getId() + " 第" + i +  "次加锁中...");
            redisLock.lock();
            isLocked = redisLock.isLocked();
            System.out.println("######### " + Thread.currentThread().getId() + " 第" + i + "次" +(isLocked ? "加锁成功！" : "加锁失败！"));
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            i = 1;
            if (redisLock.unlock()) {
                System.out.println("######### " + Thread.currentThread().getId() + " 第" + i + "次" + " 解锁成功");
            } else {
                System.out.println("######### " + Thread.currentThread().getId() + " 第" + i + "次" + " 解锁失败");
            }

            i++;
            if (redisLock.unlock()) {
                System.out.println("######### " + Thread.currentThread().getId() + " 第" + i + "次" + " 解锁成功");
            } else {
                System.out.println("######### " + Thread.currentThread().getId() + " 第" + i + "次" + " 解锁失败");
            }

            i++;
            if (redisLock.unlock()) {
                System.out.println("######### " + Thread.currentThread().getId() + " 第" + i + "次" + " 解锁成功");
            } else {
                System.out.println("######### " + Thread.currentThread().getId() + " 第" + i + "次" + " 解锁失败");
            }
        }
    }
}
