package com.sam.orderService.service;

import com.sam.orderService.config.kafka.KafkaProducerConfig;
import com.sam.orderService.dto.request.OrderRequestDTO;
import com.sam.orderService.dto.response.OrderResponseDTO;
import com.sam.orderService.entity.Order;
import com.sam.orderService.entity.OrderStatus;
import com.sam.orderService.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private ModelMapper modelMapper;
    private KafkaProducerConfig kafkaProducerConfig;

    @Override
    @Transactional
    public OrderResponseDTO placeOrder(OrderRequestDTO orderRequestDTO) {
        Order order = Order.builder()
                .customerId(orderRequestDTO.getCustomerId())
                .productId(orderRequestDTO.getProductId())
                .itemId(orderRequestDTO.getItemId())
                .quantity(orderRequestDTO.getQuantity())
                .orderDate(LocalDateTime.now())
                .totalAmount(BigDecimal.valueOf(orderRequestDTO.getQuantity() * 50.50))
                .status(OrderStatus.CONFIRMED)
                .build();

        Order savedOrder = orderRepository.saveAndFlush(order);
        return modelMapper.map(savedOrder, OrderResponseDTO.class);
    }


    @Override
    public List<OrderResponseDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(order -> modelMapper.map(order, OrderResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public OrderResponseDTO getByOrderId(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order is not found for the requested: " + id));
        return modelMapper.map(order, OrderResponseDTO.class);
    }

    public void sendToKafka(OrderResponseDTO orderResponseDTO) {
        Map<String, Object> map = new HashMap<>();
        map.put("ItemId", orderResponseDTO.getItemId());
        map.put("Quantity", orderResponseDTO.getQuantity());
        kafkaProducerConfig.sendMessage(map);
    }
}
