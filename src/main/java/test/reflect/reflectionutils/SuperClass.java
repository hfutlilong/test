package test.reflect.reflectionutils;

/**
 * @Description 父类
 * @Author lilong
 * @Date 2018-11-16 11:20
 */
public class SuperClass {
    private String fatherPrivate = "privateField爹也不太懂";
    protected String fatherProtected = "protectedField爹也不太懂";
    public String fatherPublic = "publicField爹也不太懂";

    private void fatherPrivateMethod(){
        System.out.println("父类private方法");
    }

    private void fatherProtectedMethod(){
        System.out.println("父类protected方法");
    }

    private void fatherPublicMethod(){
        System.out.println("父类public方法");
    }
}
