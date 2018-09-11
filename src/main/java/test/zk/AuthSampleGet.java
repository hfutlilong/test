package test.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class AuthSampleGet {
    private static final String PATH = "/zk-book-auth_test";
    public static void main(String[] args) {
        try {
            ZooKeeper zk1 = new ZooKeeper("192.168.145.130:2181", 5000, null);
            zk1.addAuthInfo("digest", "foo:true".getBytes());
            zk1.create(PATH, "init".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.EPHEMERAL);
//            zk1.getData(PATH, false, null);

            ZooKeeper zk2 = new ZooKeeper("192.168.145.130:2181", 5000, null);
            zk2.getData(PATH, false, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
