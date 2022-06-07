package com.bzu.assignment2.dto;

import com.bzu.assignment2.entity.Customer;
import com.bzu.assignment2.entity.ProductOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Set;

@Api(value = "Order model information")
@Data
public class OrderDto {

    @ApiModelProperty(value = "Order id")
    private Long order_id;

    @ApiModelProperty(value = "Ordered at ")
    private String orderedAt;


    public OrderDto() {
    }

    public OrderDto(Long order_id, String orderedAt, Customer customer, Set<ProductOrder> productOrders) {
        this.order_id = order_id;
        this.orderedAt = orderedAt;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(String orderedAt) {
        this.orderedAt = orderedAt;
    }

}
