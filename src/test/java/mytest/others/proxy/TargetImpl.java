package mytest.others.proxy;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-02-18 15:39
 */
public class TargetImpl implements Target {
    @Override
    public int test(int i){
        return i + 1;
    }
}
