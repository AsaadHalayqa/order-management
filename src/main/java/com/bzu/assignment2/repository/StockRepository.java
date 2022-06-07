package com.bzu.assignment2.repository;

import com.bzu.assignment2.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
