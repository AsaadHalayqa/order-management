package com.bzu.assignment2.controller;

import com.bzu.assignment2.dto.CustomerDto;
import com.bzu.assignment2.exception.BadRequestException;
import com.bzu.assignment2.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "CRUD REST APIs for Customer Resources")
@RestController
@RequestMapping("/api/v1/customer")

public class CustomerController {

    private final Logger log = LoggerFactory.getLogger(CustomerController.class);


    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Create Customer REST API")
    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customerDto) {
        if (customerDto.getCustomer_id() != null) {
            log.error("Cannot have an ID {}", customerDto);
            throw new BadRequestException(CustomerController.class.getSimpleName(), "customer_id");
        }
        return new ResponseEntity(customerService.createCustomer(customerDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get All Customers By Post ID REST API")
    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @ApiOperation(value = "Get Single Customer By ID REST API")
    @GetMapping("/{customer_id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable(name = "customer_id") Long customer_id) {
        return ResponseEntity.ok(customerService.getCustomerById(customer_id));
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Update Customer By ID REST API")
    @PutMapping("/{customer_id}")
    public ResponseEntity<CustomerDto> updatCustomer(
            @Valid @RequestBody CustomerDto customerDto, @PathVariable(name = "customer_id") Long customer_id) {
        return new ResponseEntity<>(customerService.updatCustomer(customerDto, customer_id), HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('HAS_ADMIN')")
    @ApiOperation(value = "Delete Customer By ID REST API")
    @DeleteMapping("/{customer_id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable(name = "customer_id") Long customer_id){
        customerService.deleteCustomerById(customer_id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }

}
