package com.bzu.assignment2.service;

import com.bzu.assignment2.dto.StockDto;

import java.util.List;

public interface StockService {
    StockDto createStock(StockDto stockDto);

    List<StockDto> getAllStocks();

    StockDto getStockById(Long id);

    StockDto updateStock(StockDto stockDto, Long id);

    void deleteStockById(Long id);

}
