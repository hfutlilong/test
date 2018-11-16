package test.reflect.reflectionutils;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2018-11-16 11:20
 */
public class Main {
    public static void main(String[] args) {
        //获取属性值
        printFieldVal("privateField");
        printFieldVal("protectedField");
        printFieldVal("publicField");

        //获取父类中的属性
        printFieldVal("fatherPrivate");
        printFieldVal("fatherProtected");
        printFieldVal("fatherPublic");
    }

    private static void printFieldVal(String filedName) {
        SubClass test = new SubClass();
        //获取属性
        Field field = ReflectionUtils.findField(test.getClass(), filedName, String.class);
        //赋权限，否则会抛IllegalStateException
        ReflectionUtils.makeAccessible(field);
        String val = (String)ReflectionUtils.getField(field, test);
        System.out.println(val);
    }
}
