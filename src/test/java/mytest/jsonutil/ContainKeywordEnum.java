package mytest.jsonutil;

/**
 * 是否命中关键词
 */
public enum ContainKeywordEnum implements EnumIntValue {
    NO {
        @Override
        public int intValue() {
            return 0;
        }

        @Override
        public String toString() {
            return "未命中关键词";
        }
    },
    YES {
        @Override
        public int intValue() {
            return 1;
        }

        @Override
        public String toString() {
            return "命中关键词";
        }
    };

    public static ContainKeywordEnum getByIntValue(Integer intValue) {
        if (intValue == null) {
            return null;
        }

        for (ContainKeywordEnum containKeywordEnum : ContainKeywordEnum.values()) {
            if (containKeywordEnum.intValue() == intValue) {
                return containKeywordEnum;
            }
        }

        return null;
    }
}
