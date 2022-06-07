package com.bzu.assignment2.service.impl;

import com.bzu.assignment2.dto.CustomerDto;
import com.bzu.assignment2.entity.Customer;
import com.bzu.assignment2.exception.ResourceNotFoundException;
import com.bzu.assignment2.repository.CustomerRepository;
import com.bzu.assignment2.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //To enable this class for component scanning
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    @Override
    public CustomerDto createCustomer( CustomerDto customerDto) {
        // convert DTO to entity
        Customer customer = mapToEntity(customerDto);
        Customer newCustomer = customerRepository.save(customer);

        // convert entity to DTO
        CustomerDto customerResponse = mapToDTO(newCustomer);

        return customerResponse;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        return customers.stream().map(customer -> mapToDTO(customer)).collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(Long customer_id) {
        Customer customer = customerRepository.findById(customer_id).
                orElseThrow(() -> new ResourceNotFoundException("Customer", "customer_id", customer_id));
        return mapToDTO(customer);
    }

    @Override
    public CustomerDto updatCustomer(CustomerDto customerDto, Long customer_id) {
        // get Customer by id from the database
        Customer customer = customerRepository.findById(customer_id).
                orElseThrow(() -> new ResourceNotFoundException("Customer", "customer_id", customer_id));

        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPassword(customerDto.getPassword());
        customer.setBornAt(customerDto.getBornAt());

        Customer updateCustomer = customerRepository.save(customer);

        return mapToDTO(updateCustomer);
    }

    @Override
    public void deleteCustomerById(Long customer_id) {
        // get Customer by id from the database
        Customer customer = customerRepository.findById(customer_id).
                orElseThrow(() -> new ResourceNotFoundException("Customer", "customer_id", customer_id));
        customerRepository.delete(customer);
    }

    // convert Entity into DTO
    private CustomerDto mapToDTO(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomer_id(customer.getCustomer_id());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPassword(customer.getPassword());
        customerDto.setBornAt(customer.getBornAt());

        return customerDto;
    }

    // convert DTO to entity
    private Customer mapToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setCustomer_id(customerDto.getCustomer_id());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPassword(customerDto.getPassword());
        customer.setBornAt(customerDto.getBornAt());

        return customer;
    }

}
