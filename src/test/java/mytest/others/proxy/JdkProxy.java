package mytest.others.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description JDK动态代理
 * @Author lilong
 * @Date 2019-02-18 15:40
 */
public class JdkProxy implements InvocationHandler {
    private Object proxy;

    public JdkProxy(Object proxy) {
        this.proxy = proxy;
    }

    public Target getProxy(Object proxy) {
        return (Target)Proxy.newProxyInstance(proxy.getClass().getClassLoader(),
                proxy.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object target, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("开始使用jdk动态代理");
        int useProxy = (int)method.invoke(proxy, args);
        System.out.println("结束使用jdk动态代理");
        return useProxy;
    }
}
