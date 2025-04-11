package com.sam.redis.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BasicService {

    @Cacheable(value = "exampleCache", key = "#input")
    public String performOperation(String input) {
        try {
            System.out.println("Not from CACHE");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Result for " + input;
    }
}
