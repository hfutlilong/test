package mytest.others.proxy.cglib;

public class Test {
    public static void main(String[] args) {
        HelloImpl helloProxy = CGLibProxy.getInstance().getProxy(HelloImpl.class);
        helloProxy.say("biglong");
    }
}
