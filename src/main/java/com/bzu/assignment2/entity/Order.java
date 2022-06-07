package com.bzu.assignment2.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data

@Entity                 // specifies that the class is an entity and is mapped to a database table
@Table(  //allows you to specify the details of the table that will be used to persist the entity in the database
        name = "order_tbl"
)
@Getter
@Setter

public class Order {
    @Id   //declare the primary key
    @GeneratedValue(
            strategy = GenerationType.AUTO //indicates that the persistence provider must assign primary keys for the entity using a database identity column.This means they are auto-incremented
    )
    private Long order_id;

    @Column
    private String orderedAt;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @JsonIgnore
    @OneToMany(mappedBy = "productOrders", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductOrder> productOrders = new HashSet<>();


}
