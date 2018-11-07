package test.javatezhongbing;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        while (true) {
            list.add("内存溢出呀，内崔溢出呀！");
        }
    }
}
