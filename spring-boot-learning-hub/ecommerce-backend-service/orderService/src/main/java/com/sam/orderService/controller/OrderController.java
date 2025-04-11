package com.sam.orderService.controller;

import com.sam.orderService.dto.request.OrderRequestDTO;
import com.sam.orderService.dto.response.OrderResponseDTO;
import com.sam.orderService.service.OrderServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
@Slf4j
public class OrderController {
    private OrderServiceImpl orderService;

    @PostMapping("/placeOrder")
    public OrderResponseDTO placeOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        log.info("Requested received to place order with request body: " + orderRequestDTO);
        OrderResponseDTO orderResponseDTO = orderService.placeOrder(orderRequestDTO);
        orderService.sendToKafka(orderResponseDTO);
        return orderResponseDTO;
    }


    @GetMapping("/getAllProducts")
    public List<OrderResponseDTO> getAllOrders() {
        log.info("Requested received to get all orders.");
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public OrderResponseDTO getByOrderId(@PathVariable Long orderId) {
        log.info("Requested received to get order for the order id: " + orderId);
        return orderService.getByOrderId(orderId);
    }

}

