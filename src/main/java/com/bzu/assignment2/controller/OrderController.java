package com.bzu.assignment2.controller;

import com.bzu.assignment2.dto.OrderDto;
import com.bzu.assignment2.exception.BadRequestException;
import com.bzu.assignment2.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "CRUD REST APIs for Order Resources")
@RestController
@RequestMapping("/api/v1/order")

public class OrderController {
    private final Logger log = LoggerFactory.getLogger(CustomerController.class);

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ApiOperation(value = "Create Order REST API")
    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody OrderDto orderDto){
        if(orderDto.getOrder_id() != null){
            log.error("Cannot have an ID {}", orderDto);
            throw new BadRequestException(CustomerController.class.getSimpleName(), "order_id");
        }
        return new ResponseEntity(orderService.createOrder(orderDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get All Orders By Post ID REST API")
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @ApiOperation(value = "Get Single Order By ID REST API")
    @GetMapping("/{order_id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable(name = "order_id") Long order_id) {
        return ResponseEntity.ok(orderService.getOrderById(order_id));
    }

    @ApiOperation(value = "Update Order By ID REST API")
    @PutMapping("/{order_id}")
    public ResponseEntity<OrderDto> updateOrder(
            @Valid @RequestBody OrderDto orderDto, @PathVariable(name = "order_id") Long order_id) {
        return new ResponseEntity<>(orderService.updateOrder(orderDto, order_id), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Order By ID REST API")
    @DeleteMapping("/{order_id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable(name = "order_id") Long order_id){
        orderService.deleteOrderById(order_id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }


}
