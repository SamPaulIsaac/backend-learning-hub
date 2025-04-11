package com.sam.productService.config.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sam.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class KafkaConsumer {

    @Value("${kafka.topic.name}")
    public String topic;

    @Value("${kafka.group.id}")
    public String groupId;

    @Autowired
    private ProductService productService;

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.group.id}")
    public void listen(String message) throws JsonProcessingException {
        System.out.println("Received Message: " + message);
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<Map<String, Object>> typeRef = new TypeReference<>() {
        };
        Map<String, Object> converted = objectMapper.readValue(message, typeRef);
        System.out.println("Converted K: " + converted.keySet());
        System.out.println("Converted V: " + converted.values());
        productService.updateQuantity(Long.parseLong(converted.get("ItemId").toString()),
                Integer.parseInt(converted.get("Quantity").toString()));
    }
}
