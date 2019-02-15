package mytest.jsonutil;

/**
 * 商品评论的反垃圾状态
 */
public enum AntispamStatusEnum implements EnumIntValue {
    ABNORMAL {
        @Override
        public int intValue() {
            return -2;
        }

        @Override
        public String toString() {
            return "异常";
        }
    },
    NORMAL {
        @Override
        public int intValue() {
            return 1;
        }

        @Override
        public String toString() {
            return "正常";
        }
    },
    DELETED {
        @Override
        public int intValue() {
            return 3;
        }

        @Override
        public String toString() {
            return "反垃圾判定删除";
        }
    };

    public static AntispamStatusEnum getByIntValue(Integer intValue) {
        if (intValue == null) {
            return null;
        }

        for (AntispamStatusEnum antispamStatusEnum : AntispamStatusEnum.values()) {
            if (antispamStatusEnum.intValue() == intValue) {
                return antispamStatusEnum;
            }
        }

        return null;
    }
}
