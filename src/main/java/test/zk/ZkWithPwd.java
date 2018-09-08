package test.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

public class ZkWithPwd implements Watcher {
    private static CountDownLatch connectedSemophore = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        ZooKeeper zk = new ZooKeeper("192.168.145.130:2181", 5000, new ZkWithPwd());
        connectedSemophore.await();

        long sessionId = zk.getSessionId();
        byte[] pwd = zk.getSessionPasswd();
        System.out.println("sessionId=" + sessionId);
        System.out.println("pwd=" + pwd);

        //使用错误的sessionId和Pwd
        zk = new ZooKeeper("192.168.145.130:2181", 5000, new ZkWithPwd(), 1L, "test".getBytes());

        //使用正确的sessionId和pwd
        zk = new ZooKeeper("192.168.145.130:2181", 5000, new ZkWithPwd(), sessionId, pwd);

        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override
    public void process(WatchedEvent event){
        System.out.println("Receive watched event:" + event);
        if (Event.KeeperState.SyncConnected == event.getState()) {
            connectedSemophore.countDown();
        }
    }
}
