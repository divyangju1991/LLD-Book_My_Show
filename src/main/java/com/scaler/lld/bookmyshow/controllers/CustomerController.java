package com.scaler.lld.bookmyshow.controllers;

import com.scaler.lld.bookmyshow.dtos.CreateCustomerDTO;
import com.scaler.lld.bookmyshow.models.Customer;
import com.scaler.lld.bookmyshow.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Customer createCustomer(@RequestBody CreateCustomerDTO customerRequest) {
        try {
            return customerService.createCustomer(customerRequest);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;

    }
}
