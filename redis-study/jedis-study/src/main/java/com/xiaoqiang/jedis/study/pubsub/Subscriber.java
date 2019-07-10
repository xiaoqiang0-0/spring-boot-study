package com.xiaoqiang.jedis.study.pubsub;

import lombok.Data;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.util.UUID;

@Data
public class Subscriber {
    private String id;
    private final Jedis jedis;
    private final String channel;

    public Subscriber(String id, Jedis jedis, String channel) {
        this.id = id;
        this.jedis = jedis;
        this.channel = channel;
        jedis.subscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                Subscriber.this.onMessage(channel, message);
            }
        }, channel);
    }

    public Subscriber(Jedis jedis, String channel) {
        this(UUID.randomUUID().toString(), jedis, channel);
    }

    public void onMessage(String channel, String message){
        System.out.printf("[ID:%s] 收到消息：{from:[%s], content:%s}\n", id, channel, message);
    }
}
