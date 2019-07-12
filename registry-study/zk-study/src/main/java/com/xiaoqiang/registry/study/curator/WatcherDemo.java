package com.xiaoqiang.registry.study.curator;

import com.xiaoqiang.registry.study.ZKUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

public class WatcherDemo {
    public static void main(String[] args) throws Exception {
        CuratorFramework framework = ZKUtils.getCuratorFramework();

        framework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/curator/create", "curator test".getBytes());

        Stat stat = new Stat();
        framework.getData().storingStatIn(stat).usingWatcher(new MyWatcher()).forPath("/curator/create");

        framework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/curator/create2", "curator test2".getBytes());

        framework.setData().withVersion(stat.getVersion()).forPath("/curator/create", "test2".getBytes());
        System.out.println(framework.checkExists().forPath("/curator/create"));

    }

    static class MyWatcher implements Watcher {

        @Override
        public void process(WatchedEvent watchedEvent) {
            System.out.println(watchedEvent);
        }
    }
}
