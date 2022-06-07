package com.bzu.assignment2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data

@Entity                 // specifies that the class is an entity and is mapped to a database table
@Table(  //allows you to specify the details of the table that will be used to persist the entity in the database
        name = "productOrder_tbl"
)
@Getter
@Setter

public class ProductOrder {

    @EmbeddedId
    @JsonIgnore
    private ProductOrderId id;

    @Column
    private int quantity;

    @Column
    private float price;

    @Column
    private float vat;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productO_id", nullable = false)
    private Product productOrders;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderP_id", nullable = false)
    private Order orderProducts;



}
