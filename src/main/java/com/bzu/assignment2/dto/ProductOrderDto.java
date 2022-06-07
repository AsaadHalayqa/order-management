package com.bzu.assignment2.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Api(value = "Product_Order model information")
@Data
public class ProductOrderDto {

    @ApiModelProperty(value = "Product_Order => product_id")
    private Long product_id;

    @ApiModelProperty(value = "Product_Order => order_id")
    private Long order_id;

    @ApiModelProperty(value = "Product_Order quantity")
    private int quantity;

    @ApiModelProperty(value = "Product_Order price")
    private float price;

    @ApiModelProperty(value = "Product_Order vat")
    private float vat;

    public ProductOrderDto() {

    }

    public ProductOrderDto(Long product_id, Long order_id, int quantity, float price, float vat) {
        this.product_id = product_id;
        this.order_id = order_id;
        this.quantity = quantity;
        this.price = price;
        this.vat = vat;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getVat() {
        return vat;
    }

    public void setVat(float vat) {
        this.vat = vat;
    }
}
