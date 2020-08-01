package com.ws.auth.common.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ClusterServersConfig
 * @Deacription TODO
 * @Author apple
 * @Date 2020/8/1 20:41
 * @Version 1.0
 **/

@Configuration
public class ClusterServersConfig {

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient(){

        Config config = new Config();
        config.useSingleServer()
                // .setPassword("john")
                .setAddress("redis://127.0.0.1:6379" );
                // use "rediss://" for SSL connection
                //.addNodeAddress("redis://112.74.31.211:7002", "redis://112.74.31.211:7003","redis://112.74.31.211:7004")
                //.addNodeAddress("redis://112.74.31.211:7005","redis://112.74.31.211:7006","redis://112.74.31.211:7007");

        return Redisson.create(config);
    }

}
