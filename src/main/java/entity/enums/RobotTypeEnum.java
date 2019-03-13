package entity.enums;

public enum RobotTypeEnum {
    NORMAL(0, "普通机器人"),
    DETAULT(1, "默认机器人");

    private int intValue;
    private String desc;

    RobotTypeEnum(int intValue, String desc) {
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

    public static RobotTypeEnum valueOf(Integer intValue) {
        if (null == intValue) {
            return null;
        }
        for (RobotTypeEnum robotTypeEnum : values()) {
            if (robotTypeEnum.getIntValue() == intValue) {
                return robotTypeEnum;
            }
        }
        return null;
    }
}
