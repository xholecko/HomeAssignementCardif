package com.capgemini.holecko.home_assignment.customer;

import com.capgemini.holecko.home_assignment.utils.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class CustomerServiceImpl implements CustomerService {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private CustomerDtoMapper customerDtoMapper;

    @Override
    public Customer update(
            CustomerDTO updatedCustomer,
            Integer customerId) {
        if (customerId == null) {
            String errorMessage = "Can not update customer. Customer Id was not provided.";
            log.error(errorMessage);
            throw new CustomerException(errorMessage);
        }
        if (customerDAO.findById(customerId).isEmpty()) {
            String errorMessage = "Can not update customer. Customer does not exists, can not be updated.";
            log.error(errorMessage);
            throw new CustomerException(errorMessage);
        }
        Customer result = customerDAO.save(customerDtoMapper.apply(new Pair<>(customerId, updatedCustomer)));
        log.info("Customer successfully updated. {}", result);
        return result;
    }

    @Override
    public Customer create(CustomerDTO newCustomer) {
        Customer result = customerDAO.save(customerDtoMapper.apply(new Pair<>(null, newCustomer)));
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
