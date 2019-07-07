package com.xiaoqiang.registry.study;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class ZKReaderDemo implements Watcher {

    @Override
    public void process(WatchedEvent watchedEvent) {
    }

    private static String ADDRESS = "192.168.3.10:2181";

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper(ADDRESS, 200000, new ZKReaderDemo());
        System.out.println(zooKeeper.getState());
        byte[] result = zooKeeper.getData("/hello", false, new Stat());
        System.err.println(new String(result));
    }
}
