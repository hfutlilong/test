package mytest.jsonutil;

import java.sql.Timestamp;
import java.util.Comparator;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-01-27 15:11
 */
public class TestComparator {
    public static void main(String[] args) {
//        AntispamStatusEnum a = AntispamStatusEnum.ABNORMAL;
//        AntispamStatusEnum b = AntispamStatusEnum.NORMAL;

        Long current = System.currentTimeMillis();
        Timestamp a = new Timestamp(current);

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Timestamp b = new Timestamp(current);

        System.out.println(equals(a, b));
    }


    private static boolean equals(Object o1, Object o2) {
        if (o1 == null && o2 == null) {
            return true;
        }

        return o1 != null && o1.equals(o2);
    }
}
