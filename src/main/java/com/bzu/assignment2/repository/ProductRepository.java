package com.bzu.assignment2.repository;

import com.bzu.assignment2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
