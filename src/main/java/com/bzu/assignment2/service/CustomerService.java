package com.bzu.assignment2.service;

import com.bzu.assignment2.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer( CustomerDto customerDto);

    List<CustomerDto> getAllCustomers ();

    CustomerDto getCustomerById(Long customer_id);

    CustomerDto updatCustomer(CustomerDto customerDto ,Long customer_id);

    void deleteCustomerById(Long customer_id);

}
