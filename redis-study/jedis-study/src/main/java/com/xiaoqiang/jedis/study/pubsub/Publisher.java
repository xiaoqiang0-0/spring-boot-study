package com.xiaoqiang.jedis.study.pubsub;

import redis.clients.jedis.Jedis;

public class Publisher {
    private final Jedis jedis;
    private final String channel;

    public Publisher(Jedis jedis, String channel) {
        this.jedis = jedis;
        this.channel = channel;
    }

    public void publish(String message){
        jedis.publish(channel, message);
    }
}
