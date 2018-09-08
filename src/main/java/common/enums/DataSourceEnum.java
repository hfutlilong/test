package common.enums;

/**
 *
 * @ClassName: DataSourceEnum
 * @Description: 多数据远枚举
 */
public enum DataSourceEnum {
    /**
     * 读写数据源
     */
    READ_WRITE_DATA_SOURCE("dataSource"),

    /**
     * 只读数据源
     */
    READ_ONLY_DATA_SOURCE("readOnlyDataSource"),

    /**
     * RDS数据源
     */
    RDS_DATA_SOURCE("rdsDataSource"),

    /**
     * 只读RDS数据源
     */
    READ_ONLY_RDS_DATA_SOURCE("readOnlyRdsDataSource"),

    /**
     *  第二只读RDS数据源
     */
    SECONDARY_READ_ONLY_RDS_DATA_SOURCE("secondaryReadOnlyRdsDataSource"),

    /**
     * 智能客服RDS数据库（后续需要迁走）
     */
    CSAI_RDS_DATA_SOURCE("csaiRdsDataSource");

    private String key;

    private DataSourceEnum(String key) {
        this.key = key;
    }

    public String key() {
        return key;
    }
}
