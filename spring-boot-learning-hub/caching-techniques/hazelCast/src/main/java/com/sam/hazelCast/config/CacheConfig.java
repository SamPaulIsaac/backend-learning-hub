package com.sam.hazelCast.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class    CacheConfig {

    @Bean
    public HazelcastInstance hazelcastInstance() {
        Config config = new Config();

        // Basic map configuration for internal caching
        MapConfig mapConfig = new MapConfig();
        mapConfig.setName("cricketersCache");
        config.addMapConfig(mapConfig);

        return Hazelcast.newHazelcastInstance(config);
    }
}

