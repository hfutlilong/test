package test.zk;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

/**
 * 异步创建节点
 */
public class ZkCreateNodeASync implements Watcher {
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        ZooKeeper zk = new ZooKeeper("192.168.145.130:2181", 5000, new ZkCreateNodeASync());
        connectedSemaphore.await();

        zk.create("/zk-test-ephemeral-", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL,
                new IStringCallback(), "I am context.");

        zk.create("/zk-test-ephemeral-", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL,
                new IStringCallback(), "I am context.");

        zk.create("/zk-test-ephemeral-", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL,
                new IStringCallback(), "I am context.");

        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("Received event:" + event);
        if (Event.KeeperState.SyncConnected == event.getState()) {
            connectedSemaphore.countDown();
        }
    }
}

//rc:Return Code, 0(Ok), -4(ConnectionLoss), -110(NodeExists), -112(SessionExpired)
class IStringCallback implements AsyncCallback.StringCallback {
    @Override
    public void processResult(int rc, String path, Object ctx, String name) {
        System.out.println("Create path result:[" + rc + ", " + path + ", "
                + ctx + ", real path name: " + name);
    }
}
