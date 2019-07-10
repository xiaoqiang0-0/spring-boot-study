package com.xiaoqiang.jedis.study.pubsub;

import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

public class Main {

    public static final String CHANNEL_NAME = "TEST_CHANNEL";
    public static final String CHANNEL_NAME1 = "TEST_CHANNEL.1";
    public static final String CHANNEL_NAME2 = "TEST_CHANNEL.2";
    public static final String CHANNEL_NAME_PATTEN = "TEST_CHANNEL.*";


    public static void main(String[] args) throws InterruptedException {
        Publisher publisher1 = new Publisher(new Jedis(), CHANNEL_NAME1);
        Publisher publisher2 = new Publisher(new Jedis(), CHANNEL_NAME2);

        new Thread(()-> new Subscriber("1", new Jedis(), CHANNEL_NAME1)).start();
        new Thread(()-> new Subscriber("2", new Jedis(), CHANNEL_NAME1)).start();

        new Thread(()-> new PSubscriber("3", new Jedis(), CHANNEL_NAME_PATTEN)).start();

        int i = 0;
        for (;;){
            TimeUnit.SECONDS.sleep(3);
            publisher1.publish("Hello subscriber! "+i++);
            publisher2.publish("His subscriber! "+i++);
        }
    }
}
