package com.bzu.assignment2.service.impl;

import com.bzu.assignment2.dto.CustomerDto;
import com.bzu.assignment2.dto.ProductDto;
import com.bzu.assignment2.entity.Customer;
import com.bzu.assignment2.entity.Product;
import com.bzu.assignment2.exception.ResourceNotFoundException;
import com.bzu.assignment2.repository.ProductRepository;
import com.bzu.assignment2.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //To enable this class for component scanning

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        // convert DTO to entity
        Product product = mapToEntity(productDto);
        Product newProduct = productRepository.save(product);

        // convert entity to DTO
        ProductDto productResponse = mapToDTO(newProduct);

        return productResponse;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(product -> mapToDTO(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Long product_id) {
        Product product = productRepository.findById(product_id).
                orElseThrow(() -> new ResourceNotFoundException("Product", "product_id",
                        product_id));
        return mapToDTO(product);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Long product_id) {
        // get Customer by id from the database
        Product product = productRepository.findById(product_id).
                orElseThrow(() -> new ResourceNotFoundException("Product", "product_id",
                        product_id));

        product.setPrice(productDto.getPrice());
        product.setVat(productDto.getVat());
        product.setName(productDto.getName());
        product.setReference(productDto.getReference());
        product.setSlug(productDto.getSlug());
        product.setStockable(productDto.isStockable());

        Product updateProduct = productRepository.save(product);

        return mapToDTO(updateProduct);
    }

    @Override
    public void deleteProductById(Long product_id) {
        // get Customer by id from the database
        Product product = productRepository.findById(product_id).
                orElseThrow(() -> new ResourceNotFoundException("Product", "product_id",
                        product_id));
        productRepository.delete(product);
    }


    // convert Entity into DTO
    private ProductDto mapToDTO(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProduct_id(product.getProduct_id());
        productDto.setPrice(product.getPrice());
        productDto.setVat(product.getVat());
        productDto.setName(product.getName());
        productDto.setReference(product.getReference());
        productDto.setSlug(product.getSlug());
        productDto.setStockable(product.isStockable());

        return productDto;
    }

    // convert DTO to entity
    private Product mapToEntity(ProductDto productDto) {
        Product product = new Product();
        product.setProduct_id(productDto.getProduct_id());
        product.setPrice(productDto.getPrice());
        product.setVat(productDto.getVat());
        product.setName(productDto.getName());
        product.setReference(productDto.getReference());
        product.setSlug(productDto.getSlug());
        product.setStockable(productDto.isStockable());

        return product;
    }
}
