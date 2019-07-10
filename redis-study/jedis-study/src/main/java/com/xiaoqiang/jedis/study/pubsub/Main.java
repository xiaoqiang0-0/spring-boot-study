package com.xiaoqiang.jedis.study.pubsub;

import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

public class Main {

    public static final String CHANNEL_NAME = "TEST_CHANNEL";

    public static void main(String[] args) throws InterruptedException {
        Publisher publisher = new Publisher(new Jedis(), CHANNEL_NAME);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()-> new Subscriber(String.valueOf(finalI), new Jedis(), CHANNEL_NAME)).start();
        }
        int i = 0;
        for (;;){
            TimeUnit.SECONDS.sleep(3);
            publisher.publish("Hello subscriber! "+i++);
        }
    }
}
