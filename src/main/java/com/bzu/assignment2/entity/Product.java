package com.bzu.assignment2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data

@Entity                 // specifies that the class is an entity and is mapped to a database table
@Table(  //allows you to specify the details of the table that will be used to persist the entity in the database
        name = "product_tbl"
)
@Getter
@Setter

public class Product {
    @Id   //declare the primary key
    @GeneratedValue(
            strategy = GenerationType.AUTO //indicates that the persistence provider must assign primary keys for the entity using a database identity column.This means they are auto-incremented
    )
    private Long product_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column
    private String slug;

    @Column
    private String reference;

    @Column
    private float price;

    @Column
    private float vat;

    @Column
    private boolean stockable;

    @JsonIgnore
    @OneToMany(mappedBy = "productId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Stock> stocks = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "orderProducts", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductOrder> orderProducts = new HashSet<>();


}














