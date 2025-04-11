package com.sam.orderService.service;


import com.sam.orderService.dto.request.OrderRequestDTO;
import com.sam.orderService.dto.response.OrderResponseDTO;

import java.util.List;

public interface OrderService {
    OrderResponseDTO placeOrder(OrderRequestDTO orderRequestDTO);

    List<OrderResponseDTO> getAllOrders();

    OrderResponseDTO getByOrderId(Long id);

    void sendToKafka(OrderResponseDTO orderResponseDTO);

}
