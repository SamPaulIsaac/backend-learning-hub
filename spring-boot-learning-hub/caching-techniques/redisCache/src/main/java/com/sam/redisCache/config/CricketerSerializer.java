package com.sam.redisCache.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sam.redisCache.entity.Cricketer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.IOException;

public class CricketerSerializer implements RedisSerializer<Cricketer> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(Cricketer cricketer) throws SerializationException {
        try {
            return objectMapper.writeValueAsBytes(cricketer);
        } catch (JsonProcessingException e) {
            throw new SerializationException("Error serializing Cricketer", e);
        }
    }

    @Override
    public Cricketer deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        try {
            return objectMapper.readValue(bytes, Cricketer.class);
        } catch (IOException e) {
            throw new SerializationException("Error deserializing Cricketer", e);
        }
    }
}

