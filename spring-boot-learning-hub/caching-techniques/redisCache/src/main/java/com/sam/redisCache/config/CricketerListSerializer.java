package com.sam.redisCache.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sam.redisCache.entity.Cricketer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.IOException;
import java.util.List;

public class CricketerListSerializer implements RedisSerializer<List<Cricketer>> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(List<Cricketer> cricketers) throws SerializationException {
        try {
            return objectMapper.writeValueAsBytes(cricketers);
        } catch (JsonProcessingException e) {
            throw new SerializationException("Error serializing Cricketer list", e);
        }
    }

    @Override
    public List<Cricketer> deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        try {
            return objectMapper.readValue(bytes, objectMapper.getTypeFactory().constructCollectionType(List.class, Cricketer.class));
        } catch (IOException e) {
            throw new SerializationException("Error deserializing Cricketer list", e);
        }
    }
}

