package com.xiaoqiang.registry.study.curator.lock;

import org.apache.curator.framework.CuratorFramework;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class InterProcessMutex {
    private final String id;
    private final CuratorFramework client;
    private final String path;

    public InterProcessMutex(CuratorFramework client, String path) {
        this.client = client;
        this.path = path;
        this.id = UUID.randomUUID().toString();
    }

    public void acquire(){
        try {
            byte[] data = client.getData().forPath(path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean acquire(long time, TimeUnit unit){
        return false;
    }

    public void release(){

    }
}
