package test.zk;

import com.alibaba.fastjson.JSON;
import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

public class ZkExistSync implements Watcher {
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private static ZooKeeper zk;

    public static void main(String[] args) throws Exception {
        String path = "/zk-book";
        zk = new ZooKeeper("192.168.145.130:2181",  5000, new ZkExistSync());
        connectedSemaphore.await();

        zk.exists(path, true);
        zk.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.setData(path, "123".getBytes(), -1);
        zk.create(path + "/c1", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.delete(path + "/c1", -1);
        zk.delete(path, -1);

        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("暴走大事件：" + JSON.toJSONString(event));

        try {
            if (Event.KeeperState.SyncConnected == event.getState()) {
                if (Event.EventType.None == event.getType() && null == event.getPath()) {
                    connectedSemaphore.countDown();
                } else if (Event.EventType.NodeCreated == event.getType()) {
                    System.out.println("Node (" + event.getPath() + ") Create.");
                    zk.exists(event.getPath(), true);
                } else if (Event.EventType.NodeDeleted == event.getType()) {
                    System.out.println("Node (" + event.getPath() + ") Deleted.");
                    zk.exists(event.getPath(), true);
                } else if (Event.EventType.NodeDataChanged == event.getType()) {
                    System.out.println("Node (" + event.getPath() + ") DataChanged.");
                    zk.exists(event.getPath(), true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
