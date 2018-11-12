package test.enums;

public enum StatusEnum implements EnumIntValue {
    UNKNOWN {
        @Override
        public int intValue() {
            return -1;
        }

        @Override
        public String toString() {
            return "未知状态";
        }
    },
    /**
     * 状态1
     */
    STATUS_1 {
        @Override
        public int intValue() {
            return 0;
        }

        @Override
        public String toString() {
            return "状态1";
        }
    },
    /**
     * 状态2
     */
    STATUS_2 {
        @Override
        public int intValue() {
            return 1;
        }

        @Override
        public String toString() {
            return "状态2";
        }
    };

    public static StatusEnum getByIntValue(int value) {
        for (StatusEnum m : values()) {
            if (m.intValue() == value) {
                return m;
            }
        }
        return UNKNOWN;
    }
}
