package com.xiaoqiang.alice.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = AliceProperties.ALICE_PROPERTIES_PREFIX)
public class AliceProperties {
    public static final String ALICE_PROPERTIES_PREFIX = "alice";

    private Service service;

    @Data
    public static class Service {

        private String host;
        private Integer port;
        private String name;
        private String username;
        private String password;
        private String url;
    }
}
