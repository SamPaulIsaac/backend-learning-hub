package com.sam.crudMysql.customer.controller;


import com.sam.crudMysql.customer.dto.CustomerDto;
import com.sam.crudMysql.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
@Slf4j
public class CustomerController {

    private CustomerService customerService;

    @GetMapping(path = "/getDetails")
    public List<CustomerDto> getCustomerDetails() {
        log.info("Invoked getCustomerDetails in Customer Controller.");
        return customerService.getCustomerDetails();
    }

    @GetMapping(path = "/getDetailById/{customerId}")
    public CustomerDto getCustomerDetail(@PathVariable Integer customerId) {
        log.info("Invoked getCustomerDetail in Customer Controller.");
        return customerService.getCustomerDetail(customerId);
    }


    @PostMapping(path = "/saveDetail")
    public CustomerDto postCustomerDetail(@Valid @RequestBody CustomerDto customerDto) {
        log.info("Invoked postCustomerDetail in Customer Controller.");
        return customerService.postCustomerDetail(customerDto);
    }


    @PutMapping(path = "/updateDetails/{customerId}")
    public CustomerDto updateCustomerDetail(@PathVariable Integer customerId, @RequestBody CustomerDto customerDto) {
        log.info("Invoked updateCustomerDetail in Customer Controller.");
        return customerService.updateCustomerDetail(customerId, customerDto);
    }


    @DeleteMapping(path = "/deleteDetail/{customerId}")
    public void deleteCustomerDetail(@PathVariable Integer customerId) {
        log.info("Invoked deleteCustomerDetail in Customer Controller.");
        customerService.deleteCustomerDetail(customerId);
    }


}
