package mytest.others.proxy;

/**
 * @Description 测试动态代理
 *
 * @Author lilong
 * @Date 2019-02-18 15:49
 */
public class Test {
    public static void main(String[] args) {
        Target target = new TargetImpl();
        JdkProxy proxy = new JdkProxy(target);
        Target dynamicProxy = proxy.getProxy(target);
        int res = dynamicProxy.test(6);
        System.out.println(res);
    }
}
