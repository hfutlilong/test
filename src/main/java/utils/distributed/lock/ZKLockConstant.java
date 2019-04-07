package utils.distributed.lock;

public class ZKLockConstant {
    /**
     * 默认超时时间
     */
    public static final int DEFAULT_TRY_LOCK_TIMEOUT = 100;

    /**
     * ZK路径分隔符
     */
    public static final String ZK_SEPERATOR = "/";

    /**
     * 创建zk连接的重试间隔
     */
    public static final int BASE_SLEEP_TIME_MS = 100;

    /**
     * 创建zk连接的最大重试次数
     */
    public static final int MAX_RETRIES = 3;

    /**
     * zk锁前缀
     */
    public static final String ZK_LOCK_BASE_PREFIX = "lock";
}
