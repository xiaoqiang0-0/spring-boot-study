package com.xiaoqiang.jedis.study.pubsub;

import lombok.Data;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

@Data
public class PSubscriber {

    private final String id;
    private final Jedis jedis;
    private final String channel;

    public PSubscriber(String id, Jedis jedis, String channel) {
        this.id = id;
        this.jedis = jedis;
        this.channel = channel;
        jedis.psubscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                PSubscriber.this.onMessage(channel, message);
            }

            @Override
            public void onPMessage(String pattern, String channel, String message) {
                PSubscriber.this.onMessage(channel, message);
            }
        }, channel);
    }

    public void onMessage(String channel, String message) {
        System.out.printf("[ID:%s] 收到消息：{from:[%s], content:%s}\n", id, channel, message);
    }
}
