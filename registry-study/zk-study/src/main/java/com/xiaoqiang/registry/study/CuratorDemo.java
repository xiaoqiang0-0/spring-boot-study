package com.xiaoqiang.registry.study;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

public class CuratorDemo {

    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = ZKUtils.getCuratorFramework();

        curatorFramework.start();

        createData(curatorFramework);
        getDate(curatorFramework);
        updateData(curatorFramework);
        deleteData(curatorFramework);
    }

    private static void createData(CuratorFramework framework) throws Exception {
        framework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/data/curdTest", "Create test".getBytes());
    }

    private static void getDate(CuratorFramework framework) throws Exception {
        System.out.println(new String(framework.getData().forPath("/data/curdTest")));
    }

    private static void updateData(CuratorFramework framework) throws Exception {
        framework.setData().forPath("/data/curdTest", "Updated test".getBytes());
    }

    private static void deleteData(CuratorFramework framework) throws Exception {
        Stat stat = new Stat();
        framework.getData().storingStatIn(stat).forPath("/data/curdTest");

        framework.delete().withVersion(stat.getVersion()).forPath("/data/curdTest");
    }
}
