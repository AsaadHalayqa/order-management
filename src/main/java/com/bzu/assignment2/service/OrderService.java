package com.bzu.assignment2.service;

import com.bzu.assignment2.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);

    List<OrderDto> getAllOrders();

    OrderDto getOrderById(Long order_id);

    OrderDto updateOrder(OrderDto orderDto,Long order_id );

    void deleteOrderById(Long order_id );

}
