package test.reflect.access;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2018-11-14 11:58
 */
public class TestClass {

    private String MSG = "Original";

    private void privateMethod(String head , int tail){
        System.out.print(head + tail);
    }

    public String getMsg(){
        return MSG;
    }
}