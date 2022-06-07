package com.bzu.assignment2.service;

import com.bzu.assignment2.dto.ProductOrderDto;

import java.util.List;

public interface ProductOrderService {
    ProductOrderDto createProductOrder(ProductOrderDto productOrderDto);

    List<ProductOrderDto> getAllProductOrders();

    ProductOrderDto getProductOrderByO_P_Id(Long product_id, Long order_id );

    ProductOrderDto updateProductOrder(ProductOrderDto productOrderDto,Long product_id, Long order_id );

    void deleteProductOrderByO_P_Id(Long product_id, Long order_id);
}
