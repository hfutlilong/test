package mytest.others.proxy.javaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-02-23 15:32
 */
public class DynamicProxy implements InvocationHandler {
    //能代理任意一个类
    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    /**
     * 能接收任意数量和类型的参数、任意的返回值、任意的异常抛出
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}
