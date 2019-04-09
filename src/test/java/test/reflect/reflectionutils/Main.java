package test.reflect.reflectionutils;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2018-11-16 11:20
 */
public class Main {
    public static void main(String[] args) {
        //获取属性值
        getAndPrintField("privateField");
        getAndPrintField("protectedField");
        getAndPrintField("publicField");

        System.out.println();

        //获取父类中的属性
        getAndPrintField("fatherPrivate");
        getAndPrintField("fatherProtected");
        getAndPrintField("fatherPublic");

        System.out.println();

        //获取方法
        getAndPrintMethod("privateMethod");
        getAndPrintMethod("protectedMethod");
        getAndPrintMethod("publicMethod");

        System.out.println();

        //获取父类方法
        getAndPrintMethod("fatherPrivateMethod");
        getAndPrintMethod("fatherProtectedMethod");
        getAndPrintMethod("fatherPublicMethod");
    }

    private static void getAndPrintField(String filedName) {
        SubClass test = new SubClass();
        //获取属性
        Field field = ReflectionUtils.findField(test.getClass(), filedName, String.class);
        //赋权限，否则会抛IllegalStateException
        ReflectionUtils.makeAccessible(field);
        String val = (String)ReflectionUtils.getField(field, test);
        System.out.println(val);
    }

    private static void getAndPrintMethod(String methodName){
        SubClass test = new SubClass();
        Method method = ReflectionUtils.findMethod(test.getClass(), methodName);
        ReflectionUtils.makeAccessible(method);
        ReflectionUtils.invokeMethod(method, test);
    }
}
