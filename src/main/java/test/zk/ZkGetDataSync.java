package test.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * 同步获取节点数据
 */
public class ZkGetDataSync implements Watcher {
    private static CountDownLatch connectedSemophore = new CountDownLatch(1);
    private static ZooKeeper zk = null;
    private static Stat stat = new Stat();

    public static void main(String[] args) throws Exception {
        String path = "/zk-book";
        zk = new ZooKeeper("192.168.145.130:2181", 5000, new ZkGetDataSync());
        connectedSemophore.await();

        zk.create(path, "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println(new String(zk.getData(path, true, stat)));
        System.out.println("czxid=" + stat.getCzxid() + ", mzxid=" + stat.getMzxid());
    }


}
