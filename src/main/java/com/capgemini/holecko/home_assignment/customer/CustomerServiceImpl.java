package com.capgemini.holecko.home_assignment.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public Customer update(Customer updatedCustomer) {
        if (customerDAO.findById(updatedCustomer.getId()).isEmpty()) {
            String errorMessage = "Can not update customer. Customer does not exists, can not be updated";
            log.error(errorMessage);
            throw new CustomerException(errorMessage);
        }
        return customerDAO.save(updatedCustomer);
    }

    @Override
    public Customer create(Customer customer) {
        Optional<Customer> customerFromDB = customerDAO.findById(customer.getId());
        if (customerFromDB.isEmpty()) {
            return customerDAO.save(customer);
        }
        String errorMessage = "Can not create new customer. Customer with given ID already exists : " + customerFromDB.get();
        log.error(errorMessage);
        throw new CustomerException(errorMessage);
    }

    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @Override
    public Customer findById(Integer customerId) {
        Optional<Customer> customer = customerDAO.findById(customerId);
        if (customer.isEmpty()) {
            String errorMessage = "Can not find new customer. Customer with given ID does not exists.";
            log.error(errorMessage);
            throw new CustomerException(errorMessage);
        }
        return customer.get();
    }
}
