package com.bzu.assignment2.service.impl;

import com.bzu.assignment2.dto.ProductOrderDto;
import com.bzu.assignment2.entity.Customer;
import com.bzu.assignment2.entity.ProductOrder;
import com.bzu.assignment2.exception.ResourceNotFoundException;
import com.bzu.assignment2.repository.ProductOrderRepository;
import com.bzu.assignment2.service.ProductOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //To enable this class for component scanning

public class ProductOrderServiceImpl implements ProductOrderService {

    private ProductOrderRepository productOrderRepository;

    public ProductOrderServiceImpl(ProductOrderRepository productOrderRepository) {
        this.productOrderRepository = productOrderRepository;
    }

    @Override
    public ProductOrderDto createProductOrder(ProductOrderDto productOrderDto){
        // convert DTO to entity
        ProductOrder productOrder = mapToEntity(productOrderDto);
        ProductOrder newProductOrder = productOrderRepository.save(productOrder);

        // convert entity to DTO
        ProductOrderDto productOrderResponse = mapToDTO(newProductOrder);

        return productOrderResponse;
    }

    @Override
    public List<ProductOrderDto> getAllProductOrders() {
        List<ProductOrder> productOrders = productOrderRepository.findAll();

        return productOrders.stream().map(productOrder -> mapToDTO(productOrder)).collect(Collectors.toList());
    }

    @Override
    public ProductOrderDto getProductOrderByO_P_Id(Long product_id, Long order_id) {

        return null;
    }

    @Override
    public ProductOrderDto updateProductOrder(ProductOrderDto productOrderDto, Long product_id, Long order_id) {
        return null;
    }

    @Override
    public void deleteProductOrderByO_P_Id(Long product_id, Long order_id) {

    }


    // convert Entity into DTO
    private ProductOrderDto mapToDTO(ProductOrder productOrder){
        ProductOrderDto productOrderDto = new ProductOrderDto();
        productOrderDto.setPrice(productOrder.getPrice());
        productOrderDto.setQuantity(productOrder.getQuantity());
        productOrderDto.setVat(productOrder.getVat());
        /*
        *
        * */
        return productOrderDto;
    }

    // convert DTO to entity
    private ProductOrder mapToEntity(ProductOrderDto productOrderDto) {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setPrice(productOrderDto.getPrice());
        productOrder.setQuantity(productOrderDto.getQuantity());
        productOrder.setVat(productOrderDto.getVat());
        /*
         *
         * */
        return productOrder;
    }

}
