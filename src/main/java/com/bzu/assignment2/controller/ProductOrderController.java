package com.bzu.assignment2.controller;

import com.bzu.assignment2.dto.ProductOrderDto;
import com.bzu.assignment2.exception.BadRequestException;
import com.bzu.assignment2.service.ProductOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "CRUD REST APIs for Product_Order Resources")
@RestController
@RequestMapping("/api/v1")
public class ProductOrderController {
    private final Logger log = LoggerFactory.getLogger(CustomerController.class);

    private ProductOrderService productOrderService;

    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @ApiOperation(value = "Create Product_Order REST API")
    @PostMapping("/productOrder")
    public ResponseEntity<ProductOrderDto> createProductOrder(@Valid @RequestBody ProductOrderDto productOrderDto) {
        if (productOrderDto.getProduct_id() != null) {
            log.error("Cannot have an ID {}", productOrderDto);
            throw new BadRequestException(CustomerController.class.getSimpleName(), "product_id_O");
        }
        if (productOrderDto.getOrder_id() != null) {
            log.error("Cannot have an ID {}", productOrderDto);
            throw new BadRequestException(CustomerController.class.getSimpleName(), "order_id_P");
        }
        return new ResponseEntity(productOrderService.createProductOrder(productOrderDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get All Products_Orders By Post ID REST API")
    @GetMapping("/productOrder")
    public ResponseEntity<List<ProductOrderDto>> getAllProductOrders() {
        return ResponseEntity.ok(productOrderService.getAllProductOrders());
    }

    @ApiOperation(value = "Get Single Product_Order By ID REST API")
    @GetMapping("/productOrder/product/{product_id}/order/{order_id}")
    public ResponseEntity<ProductOrderDto> getProductOrderByO_P_Id(@PathVariable(name = "product_id") Long product_id,
                                                                   @PathVariable(name = "order_id") Long order_id) {
        return ResponseEntity.ok(productOrderService.getProductOrderByO_P_Id(product_id, order_id));
    }

    @ApiOperation(value = "Update Product_Order By ID REST API")
    @PutMapping("/productOrder/product/{product_id}/order/{order_id}")
    public ResponseEntity<ProductOrderDto> updateProductOrder(@Valid @RequestBody ProductOrderDto productOrderDto,
                                                              @PathVariable(name = "product_id") Long product_id,
                                                              @PathVariable(name = "order_id") Long order_id){
        return new ResponseEntity<>(productOrderService.updateProductOrder(productOrderDto, product_id, order_id), HttpStatus.OK);

    }

    @ApiOperation(value = "Delete Product_Order By ID REST API")
    @DeleteMapping("/productOrder/product/{product_id}/order/{order_id}")
    public ResponseEntity<String> deleteProductOrderByO_P_Id(@PathVariable(name = "product_id") Long product_id,
                                                             @PathVariable(name = "order_id") Long order_id){
        productOrderService.deleteProductOrderByO_P_Id(product_id, order_id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }



}
