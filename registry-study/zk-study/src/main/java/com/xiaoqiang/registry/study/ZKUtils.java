package com.xiaoqiang.registry.study;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class ZKUtils {
    public static String ADDRESS = "192.168.3.10:2181";

    public static ZooKeeper getClient(Watcher watcher) throws IOException {
        return new ZooKeeper(ADDRESS, 200000, watcher);
    }
}
