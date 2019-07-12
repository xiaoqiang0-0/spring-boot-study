package com.xiaoqiang.registry.study.curator.lock;

import com.xiaoqiang.registry.study.ZKUtils;
import org.apache.curator.framework.CuratorFramework;

public class DistributedLockDemo {
    public static void main(String[] args) throws Exception {
        CuratorFramework client = ZKUtils.getCuratorFramework();
        byte[]data = client.getData().forPath("/ddddsd");
    }
}
