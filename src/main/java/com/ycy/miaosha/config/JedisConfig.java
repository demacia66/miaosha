package com.ycy.miaosha.config;

import com.ycy.miaosha.redis.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author ycy
 * @email 615336738@qq.com
 * @create 2021-08-15 4:01 下午
 */
@Configuration
public class JedisConfig {

    @Autowired
    private RedisConfig redisConfig;

    @Bean
    public JedisPool jedisPoolFactory(){
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(redisConfig.getPoolMaxActive());
        poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait() * 1000);
        poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
        return new JedisPool(poolConfig,redisConfig.getHost(), redisConfig.getPort(), redisConfig.getTimeout() * 1000);
    }
}
