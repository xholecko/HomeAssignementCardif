package com.capgemini.holecko.home_assignment.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private CustomerService customerService;

    @PutMapping("/update/{customerId}")
    public Customer update(
            @RequestBody CustomerDTO updatedCustomer,
            @PathVariable Integer customerId) {
        log.info("Calling endpoint /api/customer/update/{} with {}", customerId, updatedCustomer);
        return customerService.update(updatedCustomer, customerId);
    }
}
