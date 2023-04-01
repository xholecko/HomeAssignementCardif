package com.capgemini.holecko.home_assignment.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping("/all")
    public List<CustomerDTO> getAll() {
        return customerDAO.findAll();
    }

    //temp remove
    @GetMapping("/insert")
    public CustomerDTO insert(CustomerDTO customer) {
        log.info("Calling /api/customer/insert");

        return customerService.create_TEMP_REMOVE(customer);
    }
}
