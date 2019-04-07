package utils.distributed.lock;

/**
 * @Description 时间单位
 * @Author lilong
 * @Date 2019-03-27 21:35
 */
public enum LockTimeUnit {
    MILLISECOND(1), SECOND(2);
    private Integer value;

    LockTimeUnit(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public static Integer toMillis(LockTimeUnit timeUnit) {
        if (timeUnit == LockTimeUnit.SECOND) {
            return 1000;
        } else {
            return 1;
        }
    }

}
