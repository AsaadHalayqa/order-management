package com.bzu.assignment2.controller;

import com.bzu.assignment2.dto.StockDto;
import com.bzu.assignment2.exception.BadRequestException;
import com.bzu.assignment2.service.StockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "CRUD REST APIs for Stock Resources")
@RestController
@RequestMapping("/api/v1/stock")

public class StockController {
    private final Logger log = LoggerFactory.getLogger(CustomerController.class);

    private StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @ApiOperation(value = "Create Stock REST API")
    @PostMapping
    public ResponseEntity<StockDto> createStock(@Valid @RequestBody StockDto stockDto) {
        if (stockDto.getId() != null) {
            log.error("Cannot have an ID {}", stockDto);
            throw new BadRequestException(CustomerController.class.getSimpleName(), "id");
        }
        return new ResponseEntity(stockService.createStock(stockDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get All Stocks By Post ID REST API")
    @GetMapping
    public ResponseEntity<List<StockDto>> getAllStocks() {
        return ResponseEntity.ok(stockService.getAllStocks());
    }

    @ApiOperation(value = "Get Single Stock By ID REST API")
    @GetMapping("/{id}")
    public ResponseEntity<StockDto> getStockById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(stockService.getStockById(id));
    }

    @ApiOperation(value = "Update Stock By ID REST API")
    @PutMapping("/{id}")
    public ResponseEntity<StockDto> updateStock(
            @Valid @RequestBody StockDto stockDto, @PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(stockService.updateStock(stockDto, id), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Stock By ID REST API")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStockById(@PathVariable(name = "id") Long id){
        stockService.deleteStockById(id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }

}











