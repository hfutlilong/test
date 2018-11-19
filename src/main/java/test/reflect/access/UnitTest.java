package test.reflect.access;

import java.lang.reflect.Method;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2018-11-16 19:29
 */
public class UnitTest {
    public static void main(String[] args) {
        try {
            TestClass testClass = new TestClass();
            Method method = TestClass.class.getDeclaredMethod("privateMethod", String.class, int.class);
            method.setAccessible(true);
            method.invoke(testClass, "我是头", 666);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
