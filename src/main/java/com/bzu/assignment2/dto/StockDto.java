package com.bzu.assignment2.dto;


import com.bzu.assignment2.entity.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Api(value = "Stock model information")
@Data
public class StockDto {

    @ApiModelProperty(value = "Stock id")
    private Long id;

    @ApiModelProperty(value = "Stock quantity")
    private int quantity;

    @ApiModelProperty(value = "Stock update At")
    private String updateAt;

    public StockDto() {
    }

    public StockDto(Long id, int quantity, String updateAt, Product productId) {
        this.id = id;
        this.quantity = quantity;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
}
