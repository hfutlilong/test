package test.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

public class ZkSimple implements Watcher {
    private static CountDownLatch connectedSemophore = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        ZooKeeper zk = new ZooKeeper("192.168.145.130:2181", 5000, new ZkSimple());
        System.out.println(zk.getState());
        try {
            connectedSemophore.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Zk session established.");
    }

    @Override
    public void process(WatchedEvent event){
        System.out.println("Receice watched event:" + event);
        if (Event.KeeperState.SyncConnected == event.getState()) {
            connectedSemophore.countDown();
        }
    }
}
