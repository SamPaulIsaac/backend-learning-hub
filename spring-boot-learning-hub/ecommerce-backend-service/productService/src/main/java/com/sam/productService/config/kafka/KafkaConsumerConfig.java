//package com.sam.productService.config.kafka;
//
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//
//import java.util.Map;
//
//@Configuration
//public class KafkaConsumerConfig {
//
//    @Value("kafka.topic.name=order-status-update")
//    public String topic;
//
//
//    public ConsumerFactory<String, Map<String, Object>> consumerFactory(){
//
//    }
//
//    public KafkaTemplate<String, Map<String, Object>> kafkaTemplate(){
//        return new KafkaTemplate<>(consumerFactory());
//    }
//}
