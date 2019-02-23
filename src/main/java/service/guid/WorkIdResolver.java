package service.guid;

/**
 *
 * 本机workId持有者
 */
public interface WorkIdResolver {
    /**
     * 生成机器id
     * @return
     */
    long resolveWorkId();

    /**
     * 从机器id解析出ip地址
     * @return
     */
    String parseWorkerIp(Long workId);
}
