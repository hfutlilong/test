package mytest.others.proxy.staticproxy;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-02-23 14:39
 */
public class HelloImpl implements Hello {
    @Override
    public void say(String name) {
        System.out.println("Hello! " + name);
    }
}
