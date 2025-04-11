package com.sam.crudMysql.customer.service.impl;

import com.sam.crudMysql.customer.config.Utils;
import com.sam.crudMysql.customer.config.exception.CustomerNotFoundException;
import com.sam.crudMysql.customer.dto.CustomerDto;
import com.sam.crudMysql.customer.entity.Customer;
import com.sam.crudMysql.customer.repository.CustomerRepository;
import com.sam.crudMysql.customer.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    @Override
    public List<CustomerDto> getCustomerDetails() {
        log.info("Invoked getCustomerDetails in Customer Service Impl");
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customer -> modelMapper.map(customer, CustomerDto.class)).collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerDetail(Integer customerId) {
        log.info("Invoked getCustomerDetail in Customer Service Impl");
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer not found for the requested: " + customerId));
        return modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    @Transactional
    public CustomerDto postCustomerDetail(CustomerDto customerDto) {
        log.info("Invoked postCustomerDetail in Customer Service Impl");
        customerDto.setCreatedAt(Utils.CURRENT_LOCAL_DATE_TIME);
        customerDto.setCreatedBy(Utils.USER);
        customerDto.setUpdatedBy(Utils.USER);
        customerDto.setUpdatedAt(Utils.CURRENT_LOCAL_DATE_TIME);

        Customer requestedCustomerDetail = modelMapper.map(customerDto, Customer.class);
        Customer savedCustomer = customerRepository.saveAndFlush(requestedCustomerDetail);
        return modelMapper.map(savedCustomer, CustomerDto.class);
    }

    @Override
    @Transactional
    public CustomerDto updateCustomerDetail(Integer customerId, CustomerDto customerDto) {
        log.info("Invoked updateCustomerDetail in Customer Service Impl");
        Customer existingCustomer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer not found for the requested: " + customerId));
        customerDto.setId(existingCustomer.getId());
        customerDto.setCreatedAt(existingCustomer.getCreatedAt());
        customerDto.setCreatedBy(existingCustomer.getCreatedBy());
        customerDto.setUpdatedBy(Utils.USER);
        customerDto.setUpdatedAt(Utils.CURRENT_LOCAL_DATE_TIME);

        modelMapper.map(customerDto, existingCustomer);
        Customer updatedCustomer = customerRepository.saveAndFlush(existingCustomer);
        return modelMapper.map(updatedCustomer, CustomerDto.class);
    }

    @Override
    @Transactional
    public void deleteCustomerDetail(Integer customerId) {
        log.info("Invoked deleteCustomerDetail in Customer Service Impl");
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer not found for the requested: " + customerId));
        customerRepository.deleteById(customer.getId());
    }
}
