package com.sam.redisCache.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        // Configuration for single Cricketer objects
        RedisCacheConfiguration redisCacheConfigurationForSingle = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(2))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new CricketerSerializer()));

        // Configuration for lists of Cricketers
        RedisCacheConfiguration redisCacheConfigurationForList = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(2))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new CricketerListSerializer()));

        // Build cache manager with multiple cache configurations
        return RedisCacheManager.builder(redisConnectionFactory)
                .withCacheConfiguration("cricketerCache", redisCacheConfigurationForSingle) // Cache for single Cricketer objects
                .withCacheConfiguration("cricketerListCache", redisCacheConfigurationForList) // Cache for lists of Cricketers
                .build();
    }
}
