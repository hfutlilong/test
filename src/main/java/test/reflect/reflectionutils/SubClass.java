package test.reflect.reflectionutils;

/**
 * @Description 子类
 * @Author lilong
 * @Date 2018-11-15 21:25
 */
public class SubClass extends SuperClass{
    private String privateField = "privateField大头儿子";
    protected String protectedField = "protectedField大头儿子";
    public String publicField = "publicField大头儿子";

    private void privateMethod() {
        System.out.println("子类private方法");
    }

    protected void protectedMethod() {
        System.out.println("子类protected方法");
    }

    public void publicMethod() {
        System.out.println("子类public方法");
    }

    public String getPrivateField() {
        return privateField;
    }

    public void setPrivateField(String privateField) {
        this.privateField = privateField;
    }

    public String getProtectedField() {
        return protectedField;
    }

    public void setProtectedField(String protectedField) {
        this.protectedField = protectedField;
    }

    public String getPublicField() {
        return publicField;
    }

    public void setPublicField(String publicField) {
        this.publicField = publicField;
    }
}
