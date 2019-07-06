package com.xiaoqiang.alice.autoconfigure;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AliceProperties.class)
public class AliceAutoConfiguration {
    private final AliceProperties properties;

    public AliceAutoConfiguration(AliceProperties properties) {
        this.properties = properties;
        System.out.println("alice config init...");
        System.err.println(JSON.toJSONString(properties));
        System.out.println();
    }
}
