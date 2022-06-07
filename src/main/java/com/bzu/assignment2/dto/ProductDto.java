package com.bzu.assignment2.dto;

import com.bzu.assignment2.entity.ProductOrder;
import com.bzu.assignment2.entity.Stock;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Api(value = "Product model information")
@Data
public class ProductDto {

    @ApiModelProperty(value = "Product id")
    private Long product_id;

    @ApiModelProperty(value = "Product name")
    private String name;

    @ApiModelProperty(value = "Product slug")
    private String slug;

    @ApiModelProperty(value = "Product reference")
    private String reference;

    @ApiModelProperty(value = "Product price")
    private float price;

    @ApiModelProperty(value = "Product vat")
    private float vat;

    @ApiModelProperty(value = "Product stockable")
    private boolean stockable;

    public ProductDto() {
    }

    public ProductDto(Long product_id, String name, String slug, String reference, float price, float vat, boolean stockable, Set<Stock> stocks, Set<ProductOrder> orderProducts) {
        this.product_id = product_id;
        this.name = name;
        this.slug = slug;
        this.reference = reference;
        this.price = price;
        this.vat = vat;
        this.stockable = stockable;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

    public boolean isStockable() {
        return stockable;
    }

    public void setStockable(boolean stockable) {
        this.stockable = stockable;
    }

}
