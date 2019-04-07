package mytest.distributed.lock;

import utils.distributed.lock.ZKLock;

import java.util.concurrent.CountDownLatch;

public class ZkLockTest {
    public static void main(String[] args) {
        String zkHost = "192.168.74.128:2181";
        String bizType = "test";
        String lockKey = "testZkLock";
        ZKLock zkLock = new ZKLock(zkHost, bizType, lockKey);

        // 启动3个线程模拟分布式锁竞争
        CountDownLatch conutDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                testZkLock(zkLock);
                conutDownLatch.countDown();
            }).start();
        }

        try {
            conutDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        zkLock.shutdown();
    }

    private static void testZkLock(ZKLock zkLock) {
        System.out.println("######## 开始加锁，线程信息：" + Thread.currentThread().getId() + "-" + Thread.currentThread().getName());

        if (!zkLock.lock()) {
            System.out.println("######## 加锁失败，线程信息：" + Thread.currentThread().getId() + "-" + Thread.currentThread().getName());
            return;
        }

        try {
            System.out.println("######## 加锁成功，线程信息：" + Thread.currentThread().getId() + "-" + Thread.currentThread().getName());
        } finally {
            try {
                zkLock.unLock();
                System.out.println("######## 解锁成功，线程信息：" + Thread.currentThread().getId() + "-" + Thread.currentThread().getName());
            } catch (Exception e) {
                System.out.println("######## 解锁失败，线程信息：" + Thread.currentThread().getId() + "-" + Thread.currentThread().getName());
            }
        }
    }
}
