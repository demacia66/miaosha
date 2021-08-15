package com.ycy.miaosha.redis;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ycy
 * @email 615336738@qq.com
 * @create 2021-08-15 3:27 下午
 */
@Component

// 能够读取配置文件中redis打头的
@ConfigurationProperties(prefix = "spring.redis")

@Data
public class RedisConfig {
    private String host;
    private int port;
    private int timeout;

    @Value("${spring.redis.pool.max-idle}")
    private int poolMaxIdle;

    @Value("${spring.redis.pool.max-wait}")
    private int poolMaxWait;
    //秒


    @Value("${spring.redis.pool.max-active}")
    private int poolMaxActive;
}
