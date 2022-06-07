package com.bzu.assignment2.service;

import com.bzu.assignment2.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> getAllProducts ();

    ProductDto getProductById(Long product_id);

    ProductDto updateProduct (ProductDto productDto, Long product_id);

    void deleteProductById(Long product_id);
}
