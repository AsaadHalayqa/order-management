package com.bzu.assignment2.service.impl;

import com.bzu.assignment2.dto.CustomerDto;
import com.bzu.assignment2.dto.StockDto;
import com.bzu.assignment2.entity.Customer;
import com.bzu.assignment2.entity.Stock;
import com.bzu.assignment2.exception.ResourceNotFoundException;
import com.bzu.assignment2.repository.StockRepository;
import com.bzu.assignment2.service.StockService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //To enable this class for component scanning

public class StockServiceImpl implements StockService {

    private StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public StockDto createStock(StockDto stockDto) {
        // convert DTO to entity
        Stock stock = mapToEntity(stockDto);
        Stock newStock = stockRepository.save(stock);

        // convert entity to DTO
        StockDto stockResponse = mapToDTO(newStock);

        return stockResponse;
    }

    @Override
    public List<StockDto> getAllStocks() {
        List<Stock> stocks = stockRepository.findAll();

        return stocks.stream().map(stock -> mapToDTO(stock)).collect(Collectors.toList());
    }

    @Override
    public StockDto getStockById(Long id) {
        Stock stock = stockRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Stock", "id", id));
        return mapToDTO(stock);
    }

    @Override
    public StockDto updateStock(StockDto stockDto, Long id) {
        // get Customer by id from the database
        Stock stock = stockRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Stock", "id", id));

        stock.setQuantity(stockDto.getQuantity());
        stock.setUpdateAt(stockDto.getUpdateAt());

        Stock updateStock = stockRepository.save(stock);

        return mapToDTO(updateStock);
    }

    @Override
    public void deleteStockById(Long id) {
        // get Customer by id from the database
        Stock stock = stockRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Stock", "id", id));
        stockRepository.delete(stock);
    }

    // convert Entity into DTO
    private StockDto mapToDTO(Stock stock) {
        StockDto stockDto = new StockDto();

        stockDto.setId(stock.getId());
        stockDto.setQuantity(stock.getQuantity());
        stockDto.setUpdateAt(stock.getUpdateAt());

        return stockDto;
    }

    // convert DTO to entity
    private Stock mapToEntity(StockDto stockDto) {
        Stock stock = new Stock();

        stock.setId(stockDto.getId());
        stock.setQuantity(stockDto.getQuantity());
        stock.setUpdateAt(stockDto.getUpdateAt());

        return stock;
    }
}
