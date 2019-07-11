package com.xiaoqiang.registry.study;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class ZKUtils {
    public static final String ADDRESS = "192.168.3.10:2181";
    public static final String L_ADDRESS = "localhost:2181";

    public static final String L_CLUSTER_URL = "localhost:2181,localhost:2182,localhost:2183";
    public static final String V_CLUSTER_URL="192.168.3.10:2181,192.168.3.10:2182,192.168.3.10:2183";
    public static final int SESSION_TIMEOUT = 10000;
    public static final int BASE_SLEEP_TIME = 100;
    public static final int MAX_RETRIES = 3;



    public static ZooKeeper getClient(Watcher watcher) throws IOException {
        return new ZooKeeper(L_ADDRESS, SESSION_TIMEOUT, watcher);
    }

    public static CuratorFramework getCuratorFramework() {
        return CuratorFrameworkFactory.builder().connectString(L_CLUSTER_URL).sessionTimeoutMs(SESSION_TIMEOUT)
                .retryPolicy(new ExponentialBackoffRetry(BASE_SLEEP_TIME, MAX_RETRIES)).build();
    }
}
