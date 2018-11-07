package test.javatezhongbing;

import java.util.ArrayList;
import java.util.List;

public class GCOverHead {
    /**
     * 先占掉Old区域超过12MB的空间
     */
    public final static byte[] DEFAULT_BYTES = new byte[12 * 1024 * 1024];

    public static void main(String[] args) {
        List<byte[]> temp = new ArrayList<>();
        while (true) {
            temp.add(new byte[1024 * 1024]);
            if (temp.size() > 3) {
                temp.clear();
            }
        }
    }
}
