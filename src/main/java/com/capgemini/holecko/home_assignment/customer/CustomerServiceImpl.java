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
        if (updatedCustomer.getId() == null) {
            String errorMessage = "Can not update customer. Customer Id was not provided.";
            log.error(errorMessage);
            throw new CustomerException(errorMessage);
        }
        if (customerDAO.findById(updatedCustomer.getId()).isEmpty()) {
            String errorMessage = "Can not update customer. Customer does not exists, can not be updated.";
            log.error(errorMessage);
            throw new CustomerException(errorMessage);
        }
        Customer result = customerDAO.save(updatedCustomer);
        log.info("Customer successfully updated. {}", result);
        return result;
    }

    @Override
    public Customer create(Customer customer) {
        Optional<Customer> customerFromDB = Optional.empty();
        if (customer.getId() != null) {
            customerFromDB = customerDAO.findById(customer.getId());
        }

        if (customerFromDB.isPresent()) {
            String errorMessage = "Can not create new customer. Customer with given ID already exists : " + customerFromDB.get();
            log.error(errorMessage);
            throw new CustomerException(errorMessage);
        }

        Customer result = customerDAO.save(customer);
        log.info("Creation of new customer is successful. {}", result);
        return result;
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
        log.info("Find customer by id is successful. {}", customer.get());
        return customer.get();
    }
}
