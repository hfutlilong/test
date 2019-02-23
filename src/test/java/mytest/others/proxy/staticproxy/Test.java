package mytest.others.proxy.staticproxy;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-02-23 14:59
 */
public class Test {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        Hello proxy = new HelloProxy(hello);
        proxy.say("biglong");
    }
}
