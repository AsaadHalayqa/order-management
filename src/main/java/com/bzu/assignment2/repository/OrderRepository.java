package com.bzu.assignment2.repository;

import com.bzu.assignment2.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
