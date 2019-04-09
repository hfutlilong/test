package test.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * 同步获取节点数据
 */
public class ZkGetDataSync implements Watcher {
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private static ZooKeeper zk = null;
    private static Stat stat = new Stat();

    public static void main(String[] args) throws Exception {
        String path = "/zk-book";
        zk = new ZooKeeper("192.168.145.130:2181", 5000, new ZkGetDataSync());
        connectedSemaphore.await();

        zk.create(path, "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println(new String(zk.getData(path, true, stat)));
        System.out.println("czxid=" + stat.getCzxid() + ", mzxid=" + stat.getMzxid() + ", version=" + stat.getVersion());

        zk.setData(path, "123".getBytes(), -1);

        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("Received event:" + event);
        if (Event.KeeperState.SyncConnected == event.getState()) {
            if (Event.EventType.None == event.getType() && null == event.getPath()) {
                connectedSemaphore.countDown();
            } else if (Event.EventType.NodeDataChanged == event.getType()) {
                try {
                    System.out.println(new String(zk.getData(event.getPath(), true, stat)));
                    System.out.println("czxid=" + stat.getCzxid() + ", mzxid=" + stat.getMzxid() + ", version=" + stat.getVersion());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
