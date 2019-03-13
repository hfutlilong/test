package entity.enums;

public enum RobotStatusEnum {
    DISABLED(0, "停用"),
    ENABLED(1, "启用"),
    DELETED(-1, "删除");

    private int intValue;
    private String desc;

    RobotStatusEnum(int intValue, String desc) {
        this.intValue = intValue;
        this.desc = desc;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static RobotStatusEnum valueOf(Integer intValue) {
        if (null == intValue) {
            return null;
        }
        for (RobotStatusEnum robotStatusEnum : values()) {
            if (robotStatusEnum.getIntValue() == intValue) {
                return robotStatusEnum;
            }
        }
        return null;
    }
}