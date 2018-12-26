package mytest.others.other;

import mytest.base.BaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2018-12-25 14:31
 */
public class TestMap extends BaseTest {
    @Test
    public void testMap(){
        Map<Long, Boolean> map = new HashMap<>();
        map.put(new Long(999999999999l), true);
        System.out.println(map.get(999999999999l));
    }
}
