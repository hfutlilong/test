package service.guid;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * <p>
 * 产生long类型的唯一id，基于Twitter的snow flake算法实现，单台机器每毫秒支持2^12=4096个id
 *
 * <p>
 * 第1位为0，符号位。第2-42位表示毫秒数，共41位，当前时间毫秒-2017年04月01日的毫秒数。第43-52位表示workId，即机器id，共10位，能支持1024台机器。第53-64位表示序列号，共12位
 */
@Service("commonIdGenerator")
public class CommonIdGenerator extends BaseWorkIdIdGenerator<Long> {

    public static final long START_TIME_MILLIS;

    private static final long SEQUENCE_BITS = 12L; // 12位序列号

    private static final long WORKER_ID_BITS = 10L; // 10位workId号

    private static final long SEQUENCE_MASK = (1 << SEQUENCE_BITS) - 1;

    private static final long WORK_ID_MASK = (1 << WORKER_ID_BITS) - 1; // 10位workId掩码

    private static final long WORKER_ID_LEFT_SHIFT_BITS = SEQUENCE_BITS;

    private static final long TIMESTAMP_LEFT_SHIFT_BITS = WORKER_ID_LEFT_SHIFT_BITS + WORKER_ID_BITS;

    private long sequence;

    private long lastTime;

    private final Object TIME_SEQ_LOCK = new Object();

    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, Calendar.APRIL, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        START_TIME_MILLIS = calendar.getTimeInMillis(); // 从2017.04.01开始
    }

    @Override
    public Long generateId() {
        // time
        long currentTime;
        // seq
        long seq;

        synchronized (TIME_SEQ_LOCK) {
            currentTime = System.currentTimeMillis();
            while (currentTime < lastTime) { // 极端情况：出现linux机器时钟回拨时，等待直到当前时间大于等于上次时间
                currentTime = System.currentTimeMillis();
            }

            if (currentTime == lastTime) {
                if (0L == (sequence = ++sequence & SEQUENCE_MASK)) { //如果1ms内单台机器的4096个序号用完了，等待下一毫秒
                    lastTime = waitUntilNextMillis(currentTime);
                }
            } else {
                lastTime = currentTime;
                sequence = 0;
            }
            currentTime = lastTime;
            seq = sequence;
        }

        return ((currentTime - START_TIME_MILLIS) << TIMESTAMP_LEFT_SHIFT_BITS)
                | (getWorkId() << WORKER_ID_LEFT_SHIFT_BITS) | seq;
    }

    private long waitUntilNextMillis(final long fromMills) {
        long nextMills = System.currentTimeMillis();
        while (nextMills <= fromMills) {
            nextMills = System.currentTimeMillis();
        }
        return nextMills;
    }

    @Override
    public GuidBO parseGUID(Long id) {
        GuidBO guidBO = new GuidBO();

        //1.时间戳
        long generateTimeLong = (id >> TIMESTAMP_LEFT_SHIFT_BITS) + START_TIME_MILLIS;
        guidBO.setLockTime(new Timestamp(generateTimeLong));

        //2.机器号
        Long workId = (id >> SEQUENCE_BITS) & WORK_ID_MASK;
        guidBO.setWorkId(workId);

        //3.机器ip
        guidBO.setWorkIpAddr(parseWorkerIp(workId));

        //4.序列号
        guidBO.setSequence(id & SEQUENCE_MASK);

        return guidBO;
    }
}

