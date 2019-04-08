package utils.distributed.lock;

public interface DistributedLock {
    /**
     * 阻塞式锁
     * @return
     */
    void lock();

    /**
     * 非阻塞式锁
     * @return
     */
    boolean tryLock() throws Exception;

    /**
     * 带超时时间的阻塞式锁
     * @param timeout
     * @return
     */
    boolean tryLock(long timeout) throws Exception;

    /**
     * 解锁
     */
    boolean unLock() throws Exception;

    /**
     * 释放资源
     */
    void shutdown();
}
