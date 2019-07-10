package com.xiaoqiang.jedis.study;

import redis.clients.jedis.Jedis;

public class StandAloneDemo {
    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        jedis.set("foo", "bar");
        System.out.println(jedis.get("foo"));
    }
}
