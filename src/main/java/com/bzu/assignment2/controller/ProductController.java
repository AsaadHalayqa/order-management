package com.bzu.assignment2.controller;

import com.bzu.assignment2.dto.CustomerDto;
import com.bzu.assignment2.dto.ProductDto;
import com.bzu.assignment2.exception.BadRequestException;
import com.bzu.assignment2.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "CRUD REST APIs for Product Resources")
@RestController
@RequestMapping("/api/v1/product")

public class ProductController {
    private final Logger log = LoggerFactory.getLogger(CustomerController.class);

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation(value = "Create Product REST API")
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
        if (productDto.getProduct_id() != null) {
            log.error("Cannot have an ID {}", productDto);
            throw new BadRequestException(CustomerController.class.getSimpleName(), "product_id");
        }
        return new ResponseEntity(productService.createProduct(productDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get All Products By Post ID REST API")
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @ApiOperation(value = "Get Single Product By ID REST API")
    @GetMapping("/{product_id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable(name = "product_id") Long product_id) {
        return ResponseEntity.ok(productService.getProductById(product_id));
    }

    @ApiOperation(value = "Update Product By ID REST API")
    @PutMapping("/{product_id}")
    public ResponseEntity<ProductDto> updateProduct(
            @Valid @RequestBody ProductDto productDto, @PathVariable(name = "product_id") Long product_id) {
        return new ResponseEntity<>(productService.updateProduct(productDto, product_id), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Product By ID REST API")
    @DeleteMapping("/{product_id}")
    public ResponseEntity<String> deleteProductById(@PathVariable(name = "product_id") Long product_id){
        productService.deleteProductById(product_id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }

}
