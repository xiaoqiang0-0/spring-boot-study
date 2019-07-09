package com.xiaoqiang.registry.study.watcher;

import com.xiaoqiang.registry.study.ZKUtils;
import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class CreateWatcher implements Watcher {
    public static CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    public void process(WatchedEvent event) {
        System.out.println(event);
        if (event.getType() != Event.EventType.NodeCreated) {
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {

        ZooKeeper zooKeeper = ZKUtils.getClient(new CreateWatcher());

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            zooKeeper.exists("/test1", true);
            zooKeeper.create("/watch-demo", "1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            zooKeeper.create("/test1", "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
