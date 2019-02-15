package mytest.jsonutil;

/**
 * 商品是否自营
 */
public enum SellerTypeEnum implements EnumIntValue {
    POP {
        @Override
        public int intValue() {
            return 0;
        }

        @Override
        public String toString() {
            return "POP";
        }
    },
    SELF_SUPPLIER {
        @Override
        public int intValue() {
            return 1;
        }

        @Override
        public String toString() {
            return "自营";
        }
    };

    public static SellerTypeEnum getByIntValue(Integer intValue) {
        if (intValue == null) {
            return null;
        }

        for (SellerTypeEnum sellerTypeEnum : SellerTypeEnum.values()) {
            if (sellerTypeEnum.intValue() == intValue) {
                return sellerTypeEnum;
            }
        }

        return null;
    }
}

