package com.xiaoqiang.registry.study.curator;


import com.xiaoqiang.registry.study.ZKUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;

import java.util.Collections;

public class AclDemo {

    public static void main(String[] args) throws Exception {
        CuratorFramework client = ZKUtils.getCuratorFramework();
//        client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/curator/defaultACL", "DEFAULT_ACLS".getBytes());
//
//        for (ACL acl : client.getACL().forPath("/curator/defaultACL")) {
//            System.out.println(acl);
//        }

        setACL(client);
    }

    public static void setACL(CuratorFramework client) throws Exception {
        ACL acl = new ACL();
        acl.setId(new Id("xiaoqiang", "123456"));
        acl.setPerms(1);
        client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).withACL(Collections.singletonList(acl)).forPath("/curator/acl1", "1".getBytes());
        System.out.println(new String(client.getData().forPath("/curator/acl1")));
    }

}
