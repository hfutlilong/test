package mytest.others.proxy.staticproxy;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-02-23 14:57
 */
public class HelloProxy implements Hello {
    private Hello hello;

    public HelloProxy(Hello hello) {
        this.hello = hello;
    }

    @Override
    public void say(String name) {
        before();
        hello.say(name);
        after();
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}
