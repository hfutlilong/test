package service.guid;

import java.sql.Timestamp;

/**
 * @Description 全局唯一id数据结构
 * @Author lilong
 * @Date 2019-02-21 14:44
 */
public class GuidBO {
    /**
     * 生成id的时间戳
     */
    private Timestamp lockTime;

    /**
     * 机器id
     */
    private Long workId;

    /**
     * 机器ip地址
     */
    private String workIpAddr;

    /**
     * 生成的序列号
     */
    private Long sequence;

    public Timestamp getLockTime() {
        return lockTime;
    }

    public void setLockTime(Timestamp lockTime) {
        this.lockTime = lockTime;
    }

    public Long getWorkId() {
        return workId;
    }

    public void setWorkId(Long workId) {
        this.workId = workId;
    }

    public String getWorkIpAddr() {
        return workIpAddr;
    }

    public void setWorkIpAddr(String workIpAddr) {
        this.workIpAddr = workIpAddr;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }
}