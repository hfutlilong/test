package test.javatezhongbing;

import java.util.ArrayList;
import java.util.List;

public class StringInternPermGenOOM {
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();
        while (true) {
            list.add(("快点死掉吧，快点死掉吧！！！！！！！！！！！！！！！！！" + i++).intern());
        }
    }
}
