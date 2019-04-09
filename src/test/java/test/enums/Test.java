package test.enums;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2018-11-12 11:38
 */
public class Test {
    public static void main(String[] args) {
        String unknown = StatusEnum.getByIntValue(-1).toString();
        String status_0 = StatusEnum.getByIntValue(0).toString();
        String status_1 = StatusEnum.getByIntValue(1).toString();
        String status_2 = StatusEnum.getByIntValue(2).toString();

        System.out.println(unknown);
        System.out.println(status_0);
        System.out.println(status_1);
        System.out.println(status_2);
    }
}
