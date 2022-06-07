package com.bzu.assignment2.service.impl;

import com.bzu.assignment2.dto.OrderDto;
import com.bzu.assignment2.entity.Order;
import com.bzu.assignment2.exception.ResourceNotFoundException;
import com.bzu.assignment2.repository.OrderRepository;
import com.bzu.assignment2.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //To enable this class for component scanning
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl (OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        // convert DTO to entity
        Order order = mapToEntity(orderDto);
        Order newOrder = orderRepository.save(order);

        // convert entity to DTO
        OrderDto orderResponse = mapToDTO(newOrder);

        return orderResponse;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();

        return orders.stream().map(order -> mapToDTO(order)).collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(Long order_id) {
        Order order = orderRepository.findById(order_id).
                orElseThrow(() -> new ResourceNotFoundException("Order", "order_id", order_id));
        return mapToDTO(order);
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto, Long order_id) {
        // get order by id from the database
        Order order = orderRepository.findById(order_id).
                orElseThrow(() -> new ResourceNotFoundException("Order", "order_id", order_id));

        order.setOrder_id(orderDto.getOrder_id());
        order.setOrderedAt(orderDto.getOrderedAt());

        Order updateOrder = orderRepository.save(order);

        return mapToDTO(updateOrder);
    }

    @Override
    public void deleteOrderById(Long order_id) {
        // get order by id from the database
        Order order = orderRepository.findById(order_id).
                orElseThrow(() -> new ResourceNotFoundException("Order", "order_id", order_id));

        orderRepository.delete(order);
    }

    // convert Entity into DTO
    private OrderDto mapToDTO(Order order){
        OrderDto orderDto = new OrderDto();

        orderDto.setOrder_id(order.getOrder_id());
        orderDto.setOrderedAt(order.getOrderedAt());
        return orderDto;
    }

    // convert DTO to entity
    private Order mapToEntity(OrderDto orderDto){
        Order order = new Order();

        order.setOrder_id(orderDto.getOrder_id());
        order.setOrderedAt(orderDto.getOrderedAt());
        return order;
    }

}
