package common.enums;

import org.apache.commons.lang.StringUtils;

/**
 * key-value配置表的业务类型字段枚举,不需要区分的都使用DEFAULT
 */
public enum KeyValueBizTypeEnum {
    DEFAULT;

    public static KeyValueBizTypeEnum ValueOf(String name) {
        if (StringUtils.isNotBlank(name)) {
            for (KeyValueBizTypeEnum bizTypeEnum : values()) {
                if (name.equalsIgnoreCase(bizTypeEnum.name())) {
                    return bizTypeEnum;
                }
            }
        }
        return null;
    }
}

