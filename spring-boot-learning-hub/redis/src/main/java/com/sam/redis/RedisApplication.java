package com.sam.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import redis.clients.jedis.Jedis;

@SpringBootApplication
@EnableCaching
public class RedisApplication {

    public static void main(String[] args) {

        SpringApplication.run(RedisApplication.class, args);

        String redisKey = "exampleCache::sampaulisaac51";

        try (Jedis jedis = new Jedis("localhost", 6379)) {
            String redisValue = jedis.get(redisKey);
            System.out.println("Value for key '" + redisKey + "': " + redisValue);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

}
