package test.zk;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

/**
 * 同步创建节点
 */
public class ZkCreateNodeSync implements Watcher {
    private static CountDownLatch connectedSemophore = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        ZooKeeper zk = new ZooKeeper("192.168.145.130:2181", 5000, new ZkCreateNodeSync());
        connectedSemophore.await();

        String path1 = zk.create("/zk-test-ephemeral-", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("Success create znode: " + path1);

        String path2= zk.create("/zk-test-ephemeral-", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("Success create znode: " + path2);
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("Received event:" + event);
        if (Event.KeeperState.SyncConnected == event.getState()) {
            connectedSemophore.countDown();
        }
    }
}
