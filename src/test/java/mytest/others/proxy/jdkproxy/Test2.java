package mytest.others.proxy.jdkproxy;

import mytest.others.proxy.staticproxy.Hello;
import mytest.others.proxy.staticproxy.HelloImpl;

public class Test2 {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        JDKProxy2 dynamicProxy2 = new JDKProxy2(hello);
        Hello helloProxy = dynamicProxy2.getProxy();
        helloProxy.say("biglong");
    }
}
