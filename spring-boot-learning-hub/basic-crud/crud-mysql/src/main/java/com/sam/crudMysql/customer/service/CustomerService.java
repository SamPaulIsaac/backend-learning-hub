package com.sam.crudMysql.customer.service;

import com.sam.crudMysql.customer.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getCustomerDetails();

    CustomerDto getCustomerDetail(Integer customerId);

    CustomerDto postCustomerDetail(CustomerDto customerDto);

    CustomerDto updateCustomerDetail(Integer customerId, CustomerDto customerDto);

    void deleteCustomerDetail(Integer customerId);
}
